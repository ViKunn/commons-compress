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

import java.util.HashMap;
import java.util.Map;

/**
 * Table of all byte code forms, kept apart from {@link ByteCodeForm} so that the superclass does not instantiate its own subclasses during class
 * initialization.
 */
final class ByteCodeForms {

    private static final int BC_MAX = 256;
    private static final boolean WIDENED = ByteCodeForm.WIDENED;

    private static final ByteCodeForm[] BY_OPCODE = new ByteCodeForm[BC_MAX];
    private static final Map<String, ByteCodeForm> BY_NAME = new HashMap<>(BC_MAX);

    static {
        BY_OPCODE[0] = new NoArgumentForm(0, "nop");
        BY_OPCODE[1] = new NoArgumentForm(1, "aconst_null");
        BY_OPCODE[2] = new NoArgumentForm(2, "iconst_m1");
        BY_OPCODE[3] = new NoArgumentForm(3, "iconst_0");
        BY_OPCODE[4] = new NoArgumentForm(4, "iconst_1");
        BY_OPCODE[5] = new NoArgumentForm(5, "iconst_2");
        BY_OPCODE[6] = new NoArgumentForm(6, "iconst_3");
        BY_OPCODE[7] = new NoArgumentForm(7, "iconst_4");
        BY_OPCODE[8] = new NoArgumentForm(8, "iconst_5");
        BY_OPCODE[9] = new NoArgumentForm(9, "lconst_0");
        BY_OPCODE[10] = new NoArgumentForm(10, "lconst_1");
        BY_OPCODE[11] = new NoArgumentForm(11, "fconst_0");
        BY_OPCODE[12] = new NoArgumentForm(12, "fconst_1");
        BY_OPCODE[13] = new NoArgumentForm(13, "fconst_2");
        BY_OPCODE[14] = new NoArgumentForm(14, "dconst_0");
        BY_OPCODE[15] = new NoArgumentForm(15, "dconst_1");
        BY_OPCODE[16] = new ByteForm(16, "bipush", new int[] { 16, -1 });
        BY_OPCODE[17] = new ShortForm(17, "sipush", new int[] { 17, -1, -1 });
        BY_OPCODE[18] = new StringRefForm(18, "ldc", new int[] { 18, -1 });
        BY_OPCODE[19] = new StringRefForm(19, "ldc_w", new int[] { 19, -1, -1 }, WIDENED);
        BY_OPCODE[20] = new LongForm(20, "ldc2_w", new int[] { 20, -1, -1 });
        BY_OPCODE[21] = new LocalForm(21, "iload", new int[] { 21, -1 });
        BY_OPCODE[22] = new LocalForm(22, "lload", new int[] { 22, -1 });
        BY_OPCODE[23] = new LocalForm(23, "fload", new int[] { 23, -1 });
        BY_OPCODE[24] = new LocalForm(24, "dload", new int[] { 24, -1 });
        BY_OPCODE[25] = new LocalForm(25, "aload", new int[] { 25, -1 });
        BY_OPCODE[26] = new NoArgumentForm(26, "iload_0");
        BY_OPCODE[27] = new NoArgumentForm(27, "iload_1");
        BY_OPCODE[28] = new NoArgumentForm(28, "iload_2");
        BY_OPCODE[29] = new NoArgumentForm(29, "iload_3");
        BY_OPCODE[30] = new NoArgumentForm(30, "lload_0");
        BY_OPCODE[31] = new NoArgumentForm(31, "lload_1");
        BY_OPCODE[32] = new NoArgumentForm(32, "lload_2");
        BY_OPCODE[33] = new NoArgumentForm(33, "lload_3");
        BY_OPCODE[34] = new NoArgumentForm(34, "fload_0");
        BY_OPCODE[35] = new NoArgumentForm(35, "fload_1");
        BY_OPCODE[36] = new NoArgumentForm(36, "fload_2");
        BY_OPCODE[37] = new NoArgumentForm(37, "fload_3");
        BY_OPCODE[38] = new NoArgumentForm(38, "dload_0");
        BY_OPCODE[39] = new NoArgumentForm(39, "dload_1");
        BY_OPCODE[40] = new NoArgumentForm(40, "dload_2");
        BY_OPCODE[41] = new NoArgumentForm(41, "dload_3");
        BY_OPCODE[42] = new NoArgumentForm(42, "aload_0");
        BY_OPCODE[43] = new NoArgumentForm(43, "aload_1");
        BY_OPCODE[44] = new NoArgumentForm(44, "aload_2");
        BY_OPCODE[45] = new NoArgumentForm(45, "aload_3");
        BY_OPCODE[46] = new NoArgumentForm(46, "iaload");
        BY_OPCODE[47] = new NoArgumentForm(47, "laload");
        BY_OPCODE[48] = new NoArgumentForm(48, "faload");
        BY_OPCODE[49] = new NoArgumentForm(49, "daload");
        BY_OPCODE[50] = new NoArgumentForm(50, "aaload");
        BY_OPCODE[51] = new NoArgumentForm(51, "baload");
        BY_OPCODE[52] = new NoArgumentForm(52, "caload");
        BY_OPCODE[53] = new NoArgumentForm(53, "saload");
        BY_OPCODE[54] = new LocalForm(54, "istore", new int[] { 54, -1 });
        BY_OPCODE[55] = new LocalForm(55, "lstore", new int[] { 55, -1 });
        BY_OPCODE[56] = new LocalForm(56, "fstore", new int[] { 56, -1 });
        BY_OPCODE[57] = new LocalForm(57, "dstore", new int[] { 57, -1 });
        BY_OPCODE[58] = new LocalForm(58, "astore", new int[] { 58, -1 });
        BY_OPCODE[59] = new NoArgumentForm(59, "istore_0");
        BY_OPCODE[60] = new NoArgumentForm(60, "istore_1");
        BY_OPCODE[61] = new NoArgumentForm(61, "istore_2");
        BY_OPCODE[62] = new NoArgumentForm(62, "istore_3");
        BY_OPCODE[63] = new NoArgumentForm(63, "lstore_0");
        BY_OPCODE[64] = new NoArgumentForm(64, "lstore_1");
        BY_OPCODE[65] = new NoArgumentForm(65, "lstore_2");
        BY_OPCODE[66] = new NoArgumentForm(66, "lstore_3");
        BY_OPCODE[67] = new NoArgumentForm(67, "fstore_0");
        BY_OPCODE[68] = new NoArgumentForm(68, "fstore_1");
        BY_OPCODE[69] = new NoArgumentForm(69, "fstore_2");
        BY_OPCODE[70] = new NoArgumentForm(70, "fstore_3");
        BY_OPCODE[71] = new NoArgumentForm(71, "dstore_0");
        BY_OPCODE[72] = new NoArgumentForm(72, "dstore_1");
        BY_OPCODE[73] = new NoArgumentForm(73, "dstore_2");
        BY_OPCODE[74] = new NoArgumentForm(74, "dstore_3");
        BY_OPCODE[75] = new NoArgumentForm(75, "astore_0");
        BY_OPCODE[76] = new NoArgumentForm(76, "astore_1");
        BY_OPCODE[77] = new NoArgumentForm(77, "astore_2");
        BY_OPCODE[78] = new NoArgumentForm(78, "astore_3");
        BY_OPCODE[79] = new NoArgumentForm(79, "iastore");
        BY_OPCODE[80] = new NoArgumentForm(80, "lastore");
        BY_OPCODE[81] = new NoArgumentForm(81, "fastore");
        BY_OPCODE[82] = new NoArgumentForm(82, "dastore");
        BY_OPCODE[83] = new NoArgumentForm(83, "aastore");
        BY_OPCODE[84] = new NoArgumentForm(84, "bastore");
        BY_OPCODE[85] = new NoArgumentForm(85, "castore");
        BY_OPCODE[86] = new NoArgumentForm(86, "sastore");
        BY_OPCODE[87] = new NoArgumentForm(87, "pop");
        BY_OPCODE[88] = new NoArgumentForm(88, "pop2");
        BY_OPCODE[89] = new NoArgumentForm(89, "dup");
        BY_OPCODE[90] = new NoArgumentForm(90, "dup_x1");
        BY_OPCODE[91] = new NoArgumentForm(91, "dup_x2");
        BY_OPCODE[92] = new NoArgumentForm(92, "dup2");
        BY_OPCODE[93] = new NoArgumentForm(93, "dup2_x1");
        BY_OPCODE[94] = new NoArgumentForm(94, "dup2_x2");
        BY_OPCODE[95] = new NoArgumentForm(95, "swap");
        BY_OPCODE[96] = new NoArgumentForm(96, "iadd");
        BY_OPCODE[97] = new NoArgumentForm(97, "ladd");
        BY_OPCODE[98] = new NoArgumentForm(98, "fadd");
        BY_OPCODE[99] = new NoArgumentForm(99, "dadd");
        BY_OPCODE[100] = new NoArgumentForm(100, "isub");
        BY_OPCODE[101] = new NoArgumentForm(101, "lsub");
        BY_OPCODE[102] = new NoArgumentForm(102, "fsub");
        BY_OPCODE[103] = new NoArgumentForm(103, "dsub");
        BY_OPCODE[104] = new NoArgumentForm(104, "imul");
        BY_OPCODE[105] = new NoArgumentForm(105, "lmul");
        BY_OPCODE[106] = new NoArgumentForm(106, "fmul");
        BY_OPCODE[107] = new NoArgumentForm(107, "dmul");
        BY_OPCODE[108] = new NoArgumentForm(108, "idiv");
        BY_OPCODE[109] = new NoArgumentForm(109, "ldiv");
        BY_OPCODE[110] = new NoArgumentForm(110, "fdiv");
        BY_OPCODE[111] = new NoArgumentForm(111, "ddiv");
        BY_OPCODE[112] = new NoArgumentForm(112, "irem");
        BY_OPCODE[113] = new NoArgumentForm(113, "lrem");
        BY_OPCODE[114] = new NoArgumentForm(114, "frem");
        BY_OPCODE[115] = new NoArgumentForm(115, "drem");
        BY_OPCODE[116] = new NoArgumentForm(116, "");
        BY_OPCODE[117] = new NoArgumentForm(117, "lneg");
        BY_OPCODE[118] = new NoArgumentForm(118, "fneg");
        BY_OPCODE[119] = new NoArgumentForm(119, "dneg");
        BY_OPCODE[120] = new NoArgumentForm(120, "ishl");
        BY_OPCODE[121] = new NoArgumentForm(121, "lshl");
        BY_OPCODE[122] = new NoArgumentForm(122, "ishr");
        BY_OPCODE[123] = new NoArgumentForm(123, "lshr");
        BY_OPCODE[124] = new NoArgumentForm(124, "iushr");
        BY_OPCODE[125] = new NoArgumentForm(125, "lushr");
        BY_OPCODE[126] = new NoArgumentForm(126, "iand");
        BY_OPCODE[127] = new NoArgumentForm(127, "land");
        BY_OPCODE[128] = new NoArgumentForm(128, "ior");
        BY_OPCODE[129] = new NoArgumentForm(129, "lor");
        BY_OPCODE[130] = new NoArgumentForm(130, "ixor");
        BY_OPCODE[131] = new NoArgumentForm(131, "lxor");
        BY_OPCODE[132] = new IincForm(132, "iinc", new int[] { 132, -1, -1 });
        BY_OPCODE[133] = new NoArgumentForm(133, "i2l");
        BY_OPCODE[134] = new NoArgumentForm(134, "i2f");
        BY_OPCODE[135] = new NoArgumentForm(135, "i2d");
        BY_OPCODE[136] = new NoArgumentForm(136, "l2i");
        BY_OPCODE[137] = new NoArgumentForm(137, "l2f");
        BY_OPCODE[138] = new NoArgumentForm(138, "l2d");
        BY_OPCODE[139] = new NoArgumentForm(139, "f2i");
        BY_OPCODE[140] = new NoArgumentForm(140, "f2l");
        BY_OPCODE[141] = new NoArgumentForm(141, "f2d");
        BY_OPCODE[142] = new NoArgumentForm(142, "d2i");
        BY_OPCODE[143] = new NoArgumentForm(143, "d2l");
        BY_OPCODE[144] = new NoArgumentForm(144, "d2f");
        BY_OPCODE[145] = new NoArgumentForm(145, "i2b");
        BY_OPCODE[146] = new NoArgumentForm(146, "i2c");
        BY_OPCODE[147] = new NoArgumentForm(147, "i2s");
        BY_OPCODE[148] = new NoArgumentForm(148, "lcmp");
        BY_OPCODE[149] = new NoArgumentForm(149, "fcmpl");
        BY_OPCODE[150] = new NoArgumentForm(150, "fcmpg");
        BY_OPCODE[151] = new NoArgumentForm(151, "dcmpl");
        BY_OPCODE[152] = new NoArgumentForm(152, "dcmpg");
        BY_OPCODE[153] = new LabelForm(153, "ifeq", new int[] { 153, -1, -1 });
        BY_OPCODE[154] = new LabelForm(154, "ifne", new int[] { 154, -1, -1 });
        BY_OPCODE[155] = new LabelForm(155, "iflt", new int[] { 155, -1, -1 });
        BY_OPCODE[156] = new LabelForm(156, "ifge", new int[] { 156, -1, -1 });
        BY_OPCODE[157] = new LabelForm(157, "ifgt", new int[] { 157, -1, -1 });
        BY_OPCODE[158] = new LabelForm(158, "ifle", new int[] { 158, -1, -1 });
        BY_OPCODE[159] = new LabelForm(159, "if_icmpeq", new int[] { 159, -1, -1 });
        BY_OPCODE[160] = new LabelForm(160, "if_icmpne", new int[] { 160, -1, -1 });
        BY_OPCODE[161] = new LabelForm(161, "if_icmplt", new int[] { 161, -1, -1 });
        BY_OPCODE[162] = new LabelForm(162, "if_icmpge", new int[] { 162, -1, -1 });
        BY_OPCODE[163] = new LabelForm(163, "if_icmpgt", new int[] { 163, -1, -1 });
        BY_OPCODE[164] = new LabelForm(164, "if_icmple", new int[] { 164, -1, -1 });
        BY_OPCODE[165] = new LabelForm(165, "if_acmpeq", new int[] { 165, -1, -1 });
        BY_OPCODE[166] = new LabelForm(166, "if_acmpne", new int[] { 166, -1, -1 });
        BY_OPCODE[167] = new LabelForm(167, "goto", new int[] { 167, -1, -1 });
        BY_OPCODE[168] = new LabelForm(168, "jsr", new int[] { 168, -1, -1 });
        BY_OPCODE[169] = new LocalForm(169, "ret", new int[] { 169, -1 });
        BY_OPCODE[170] = new TableSwitchForm(170, "tableswitch");
        BY_OPCODE[171] = new LookupSwitchForm(171, "lookupswitch");
        BY_OPCODE[172] = new NoArgumentForm(172, "ireturn");
        BY_OPCODE[173] = new NoArgumentForm(173, "lreturn");
        BY_OPCODE[174] = new NoArgumentForm(174, "freturn");
        BY_OPCODE[175] = new NoArgumentForm(175, "dreturn");
        BY_OPCODE[176] = new NoArgumentForm(176, "areturn");
        BY_OPCODE[177] = new NoArgumentForm(177, "return");
        BY_OPCODE[178] = new FieldRefForm(178, "getstatic", new int[] { 178, -1, -1 });
        BY_OPCODE[179] = new FieldRefForm(179, "putstatic", new int[] { 179, -1, -1 });
        BY_OPCODE[180] = new FieldRefForm(180, "getfield", new int[] { 180, -1, -1 });
        BY_OPCODE[181] = new FieldRefForm(181, "putfield", new int[] { 181, -1, -1 });
        BY_OPCODE[182] = new MethodRefForm(182, "invokevirtual", new int[] { 182, -1, -1 });
        BY_OPCODE[183] = new MethodRefForm(183, "invokespecial", new int[] { 183, -1, -1 });
        BY_OPCODE[184] = new MethodRefForm(184, "invokestatic", new int[] { 184, -1, -1 });
        BY_OPCODE[185] = new IMethodRefForm(185, "invokeinterface", new int[] { 185, -1, -1, /* count */-1, 0 });
        BY_OPCODE[186] = new NoArgumentForm(186, "xxxunusedxxx");
        BY_OPCODE[187] = new NewClassRefForm(187, "new", new int[] { 187, -1, -1 });
        BY_OPCODE[188] = new ByteForm(188, "newarray", new int[] { 188, -1 });
        BY_OPCODE[189] = new ClassRefForm(189, "anewarray", new int[] { 189, -1, -1 });
        BY_OPCODE[190] = new NoArgumentForm(190, "arraylength");
        BY_OPCODE[191] = new NoArgumentForm(191, "athrow");
        BY_OPCODE[192] = new ClassRefForm(192, "checkcast", new int[] { 192, -1, -1 });
        BY_OPCODE[193] = new ClassRefForm(193, "instanceof", new int[] { 193, -1, -1 });
        BY_OPCODE[194] = new NoArgumentForm(194, "monitorenter");
        BY_OPCODE[195] = new NoArgumentForm(195, "monitorexit");
        BY_OPCODE[196] = new WideForm(196, "wide");
        BY_OPCODE[197] = new MultiANewArrayForm(197, "multianewarray", new int[] { 197, -1, -1, -1 });
        BY_OPCODE[198] = new LabelForm(198, "ifnull", new int[] { 198, -1, -1 });
        BY_OPCODE[199] = new LabelForm(199, "ifnonnull", new int[] { 199, -1, -1 });
        BY_OPCODE[200] = new LabelForm(200, "goto_w", new int[] { 200, -1, -1, -1, -1 }, WIDENED);
        BY_OPCODE[201] = new LabelForm(201, "jsr_w", new int[] { 201, -1, -1, -1, -1 }, WIDENED);

        // Extra ones defined by pack200
        BY_OPCODE[202] = new ThisFieldRefForm(202, "getstatic_this", new int[] { 178, -1, -1 });
        BY_OPCODE[203] = new ThisFieldRefForm(203, "putstatic_this", new int[] { 179, -1, -1 });
        BY_OPCODE[204] = new ThisFieldRefForm(204, "getfield_this", new int[] { 180, -1, -1 });
        BY_OPCODE[205] = new ThisFieldRefForm(205, "putfield_this", new int[] { 181, -1, -1 });
        BY_OPCODE[206] = new ThisMethodRefForm(206, "invokevirtual_this", new int[] { 182, -1, -1 });
        BY_OPCODE[207] = new ThisMethodRefForm(207, "invokespecial_this", new int[] { 183, -1, -1 });
        BY_OPCODE[208] = new ThisMethodRefForm(208, "invokestatic_this", new int[] { 184, -1, -1 });
        BY_OPCODE[209] = new ThisFieldRefForm(209, "aload_0_getstatic_this", new int[] { 42, 178, -1, -1 });
        BY_OPCODE[210] = new ThisFieldRefForm(210, "aload_0_putstatic_this", new int[] { 42, 179, -1, -1 });
        BY_OPCODE[211] = new ThisFieldRefForm(211, "aload_0_getfield_this", new int[] { 42, 180, -1, -1 });
        BY_OPCODE[212] = new ThisFieldRefForm(212, "aload_0_putfield_this", new int[] { 42, 181, -1, -1 });
        BY_OPCODE[213] = new ThisMethodRefForm(213, "aload_0_invokevirtual_this", new int[] { 42, 182, -1, -1 });
        BY_OPCODE[214] = new ThisMethodRefForm(214, "aload_0_invokespecial_this", new int[] { 42, 183, -1, -1 });
        BY_OPCODE[215] = new ThisMethodRefForm(215, "aload_0_invokestatic_this", new int[] { 42, 184, -1, -1 });
        BY_OPCODE[216] = new SuperFieldRefForm(216, "getstatic_super", new int[] { 178, -1, -1 });
        BY_OPCODE[217] = new SuperFieldRefForm(217, "putstatic_super", new int[] { 179, -1, -1 });
        BY_OPCODE[218] = new SuperFieldRefForm(218, "getfield_super", new int[] { 180, -1, -1 });
        BY_OPCODE[219] = new SuperFieldRefForm(219, "putfield_super", new int[] { 181, -1, -1 });
        BY_OPCODE[220] = new SuperMethodRefForm(220, "invokevirtual_super", new int[] { 182, -1, -1 });
        BY_OPCODE[221] = new SuperMethodRefForm(221, "invokespecial_super", new int[] { 183, -1, -1 });
        BY_OPCODE[222] = new SuperMethodRefForm(222, "invokestatic_super", new int[] { 184, -1, -1 });
        BY_OPCODE[223] = new SuperFieldRefForm(223, "aload_0_getstatic_super", new int[] { 42, 178, -1, -1 });
        BY_OPCODE[224] = new SuperFieldRefForm(224, "aload_0_putstatic_super", new int[] { 42, 179, -1, -1 });
        BY_OPCODE[225] = new SuperFieldRefForm(225, "aload_0_getfield_super", new int[] { 42, 180, -1, -1 });
        BY_OPCODE[226] = new SuperFieldRefForm(226, "aload_0_putfield_super", new int[] { 42, 181, -1, -1 });
        BY_OPCODE[227] = new SuperMethodRefForm(227, "aload_0_invokevirtual_super", new int[] { 42, 182, -1, -1 });
        BY_OPCODE[228] = new SuperMethodRefForm(228, "aload_0_invokespecial_super", new int[] { 42, 183, -1, -1 });
        BY_OPCODE[229] = new SuperMethodRefForm(229, "aload_0_invokestatic_super", new int[] { 42, 184, -1, -1 });
        BY_OPCODE[230] = new ThisInitMethodRefForm(230, "invokespecial_this_init", new int[] { 183, -1, -1 });
        BY_OPCODE[231] = new SuperInitMethodRefForm(231, "invokespecial_super_init", new int[] { 183, -1, -1 });
        BY_OPCODE[232] = new NewInitMethodRefForm(232, "invokespecial_new_init", new int[] { 183, -1, -1 });
        BY_OPCODE[233] = new NarrowClassRefForm(233, "cldc", new int[] { 18, -1 });
        BY_OPCODE[234] = new IntRefForm(234, "ildc", new int[] { 18, -1 });
        BY_OPCODE[235] = new FloatRefForm(235, "fldc", new int[] { 18, -1 });
        BY_OPCODE[236] = new NarrowClassRefForm(236, "cldc_w", new int[] { 19, -1, -1 }, WIDENED);
        BY_OPCODE[237] = new IntRefForm(237, "ildc_w", new int[] { 19, -1, -1 }, WIDENED);
        BY_OPCODE[238] = new FloatRefForm(238, "fldc_w", new int[] { 19, -1, -1 }, WIDENED);
        BY_OPCODE[239] = new DoubleForm(239, "dldc2_w", new int[] { 20, -1, -1 });

        // Reserved bytecodes
        BY_OPCODE[254] = new NoArgumentForm(254, "impdep1");
        BY_OPCODE[255] = new NoArgumentForm(255, "impdep2");

        // Bytecodes that aren't defined in the spec but are useful when
        // unpacking (all must be >255)
        // maybe wide versions of the others? etc.

        // Put all the bytecodes in a HashMap so we can
        // get them by either name or number
        for (final ByteCodeForm byteCode : BY_OPCODE) {
            if (byteCode != null) {
                BY_NAME.put(byteCode.getName(), byteCode);
            }
        }
    }

    static ByteCodeForm get(final int opcode) {
        return BY_OPCODE[opcode];
    }

    private ByteCodeForms() {
    }
}
