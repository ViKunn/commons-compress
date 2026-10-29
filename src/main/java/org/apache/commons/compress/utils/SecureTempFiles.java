package org.apache.commons.compress.utils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;

/**
 * Creates temporary files readable and writable only by their owner where the
 * file
 * system supports POSIX permissions.
 *
 * @since 1.29.0
 */
public final class SecureTempFiles {
   private static final boolean POSIX = FileSystems.getDefault().supportedFileAttributeViews().contains("posix");

   /**
    * Creates a temporary file.
    *
    * @param dir    directory, or null for the default temporary-file directory.
    * @param prefix file name prefix.
    * @param suffix file name suffix.
    * @return the new file.
    * @throws IOException if the file cannot be created.
    */
   public static Path create(final Path dir, final String prefix, final String suffix)
         throws IOException {
      final FileAttribute<?>[] attributes = POSIX
            ? new FileAttribute<?>[] {
                  PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rw-------")) }
            : new FileAttribute<?>[0];
      return dir == null ? Files.createTempFile(prefix, suffix, attributes)
            : Files.createTempFile(dir, prefix, suffix, attributes);
   }

   private SecureTempFiles() {
   }
}