/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.commons.compress;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.io.TempDir;

/**
 * Abstracts the use of a JUnit {@link TempDir} for all subclasses.
 */
public class AbstractTempDirTest {

    @TempDir
    private File tempDirFile;

    public File createTempFile() throws IOException {
        return File.createTempFile("testfile", "", getTempDirFile());
    }

    public File createTempFile(final String prefix, final String suffix) throws IOException {
        return File.createTempFile(prefix, suffix, getTempDirFile());
    }

    public Path createTempPath(final String prefix, final String suffix) throws IOException {
        return Files.createTempFile(getTempDirPath(), prefix, suffix);
    }

    public File getTempDirFile() {
        return tempDirFile;
    }

    public Path getTempDirPath() {
        return tempDirFile.toPath();
    }

    protected File newTempFile(final String child) {
        return new File(getTempDirFile(), child);
    }

}