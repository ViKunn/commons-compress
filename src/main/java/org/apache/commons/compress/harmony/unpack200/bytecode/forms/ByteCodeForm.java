/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import java.util.Arrays;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

/**
 * Abstract byte code form.
 */
public abstract class ByteCodeForm {

    /**
     * Indicates whether this is a widened form.
     */
    protected static final boolean WIDENED = true;

    /**
     * Gets a ByteCodeForm.
     *
     * @param opcode opcode index.
     * @return The matching ByteCodeForm at the given opcode.
     */
    public static ByteCodeForm get(final int opcode) {
        return ByteCodeForms.get(opcode);
    }

    private final int opcode;
    private final String name;
    private final int[] rewrite;
    private int firstOperandIndex;

    private int operandLength;

    /**
     * Constructs a new instance with the specified opcode and name. Assume no rewrite.
     *
     * @param opcode index corresponding to the opcode's value.
     * @param name   printable name of the opcode.
     */
    public ByteCodeForm(final int opcode, final String name) {
        this(opcode, name, new int[] { opcode });
    }

    /**
     * Constructs a new instance with the specified opcode, name, operandType and rewrite.
     *
     * @param opcode  index corresponding to the opcode's value.
     * @param name    String printable name of the opcode.
     * @param rewrite Operand positions (which will later be rewritten in ByteCodes) are indicated by -1.
     */
    public ByteCodeForm(final int opcode, final String name, final int[] rewrite) {
        this.opcode = opcode;
        this.name = name;
        this.rewrite = rewrite;
        calculateOperandPosition();
    }

    /**
     * Calculates the operand position.
     */
    protected void calculateOperandPosition() {
        firstOperandIndex = -1;
        operandLength = -1;

        // Find the first negative number in the rewrite array
        int iterationIndex = 0;
        while (iterationIndex < rewrite.length) {
            if (rewrite[iterationIndex] < 0) {
                // Found the first opcode to substitute
                firstOperandIndex = iterationIndex;
                iterationIndex = rewrite.length;
            } else {
                iterationIndex++;
            }
        }

        if (firstOperandIndex == -1) {
            // Nothing more to do since the opcode has no operands
            return;
        }

        // Find the last negative number in the rewrite array
        int lastOperandIndex = -1;
        iterationIndex = firstOperandIndex;
        while (iterationIndex < rewrite.length) {
            if (rewrite[iterationIndex] < 0) {
                lastOperandIndex = iterationIndex;
            }
            iterationIndex++;
        }

        // Now we have the first index and the last index.
        final int difference = lastOperandIndex - firstOperandIndex;

        // If last < first, something is wrong.
        if (difference < 0) {
            throw new IllegalStateException("Logic error: Not finding rewrite operands correctly");
        }
        operandLength = difference + 1;
    }

    /**
     * Gets the first operand index.
     *
     * @return The first operand index.
     */
    public int firstOperandIndex() {
        return firstOperandIndex;
    }

    /**
     * The ByteCodeForm knows how to fix up a bytecode if it needs to be fixed up because it holds a Label bytecode.
     *
     * @param byteCode      A ByteCode to be fixed up
     * @param codeAttribute A CodeAttribute used to determine how the ByteCode should be fixed up.
     */
    public void fixUpByteCodeTargets(final ByteCode byteCode, final CodeAttribute codeAttribute) {
        // Most ByteCodeForms don't have any fixing up to do.
    }

    /**
     * Gets the name.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the opcode.
     *
     * @return The opcode.
     */
    public int getOpcode() {
        return opcode;
    }

    /**
     * Gets the rewrite array.
     *
     * @return The rewrite array.
     */
    public int[] getRewrite() {
        return rewrite;
    }

    /**
     * Gets a copy of the rewrite array.
     *
     * @return A copy of the rewrite array.
     */
    public int[] getRewriteCopy() {
        return Arrays.copyOf(rewrite, rewrite.length);
    }

    /**
     * This method will answer true if the receiver is a multi-bytecode instruction (such as aload0_putfield_super); otherwise, it will answer false.
     *
     * @return boolean true if multibytecode, false otherwise
     */
    public boolean hasMultipleByteCodes() {
        // Currently, all multi-bytecode instructions
        // begin with aload_0, so this is how we test.
        if (rewrite.length > 1 && rewrite[0] == 42) {
            // If there's an instruction (not a negative
            // number, which is an operand) after the
            // aload_0, it's a multibytecode instruction.
            return rewrite[1] > 0;
        }
        return false;
    }

    /**
     * Tests whether this instance has an operand.
     *
     * @return whether this instance has an operand.
     */
    public boolean hasNoOperand() {
        return false;
    }

    /**
     * Tests whether nested entries must start in the class pool.
     *
     * @return true if nested must start in class pool.
     */
    public boolean nestedMustStartClassPool() {
        return false;
    }

    /**
     * Gets the operand length.
     *
     * @return The operand length.
     */
    public int operandLength() {
        return operandLength;
    }

    /**
     * Sets the rewrite of the byteCode.
     *
     * @param byteCode       ByteCode to be updated (!).
     * @param operandManager OperandTable from which to draw info.
     * @param codeLength     Length of bytes (excluding this bytecode) from the beginning of the method. Used in calculating padding for some variable-length
     *                       bytecodes (such as lookupswitch, tableswitch).
     * @throws Pack200Exception if a type is not supported or an index not in the range [0, {@link Integer#MAX_VALUE}].
     */
    public abstract void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int codeLength) throws Pack200Exception;

    @Override
    public String toString() {
        return this.getClass().getName() + "(" + getName() + ")";
    }
}
