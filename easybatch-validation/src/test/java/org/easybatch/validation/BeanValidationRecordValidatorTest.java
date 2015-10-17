/*
 * The MIT License
 *
 *  Copyright (c) 2015, Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package org.easybatch.validation;

import org.easybatch.core.validator.RecordValidationException;

import static org.assertj.core.api.Assertions.assertThat;

public class BeanValidationRecordValidatorTest {

    private BeanValidationRecordValidator<Foo> validator;

    @org.junit.Before
    public void setUp() throws Exception {
        validator = new BeanValidationRecordValidator<Foo>();
    }

    @org.junit.Test(expected = RecordValidationException.class)
    public void nonValidBeanShouldBeRejected() throws Exception {
        Foo foo = new Foo(-1, null);
        validator.processRecord(foo);
    }

    @org.junit.Test
    public void validBeanShouldBeAccepted() throws Exception {
        Foo foo = new Foo(1, "bar");
        Foo result = validator.processRecord(foo);
        assertThat(result).isNotNull();
    }

}
