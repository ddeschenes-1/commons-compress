/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.commons.compress.utils;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class BoundedSeekableByteChannelInputStreamTest {

    @Test
    public void checkRestrictedRead() throws IOException {
        byte[] readContent;
        try (SeekableInMemoryByteChannel channel = new SeekableInMemoryByteChannel("Hello World!".getBytes(UTF_8));
                BoundedSeekableByteChannelInputStream input = new BoundedSeekableByteChannelInputStream(0, 5, channel)) {
            readContent = IOUtils.toByteArray(input);
        }
        assertEquals(5, readContent.length);
        assertArrayEquals("Hello".getBytes(UTF_8), readContent);
    }

}