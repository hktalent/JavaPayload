/*
 * Java Payloads.
 * 
 * Copyright (c) 2012 Michael 'mihi' Schierl
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *   
 * - Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *   
 * - Neither name of the copyright holders nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 *   
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND THE CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDERS OR THE CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS
 * OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package javapayload.handler.dynstager;

import javapayload.Parameter;

public class Crypt extends DynStagerHandler {

	public Crypt() {
		super("Crypt a Stager class with a Crypter", true, true,
				"This dynstager can be used to crypt a Stager. When adding this stager to a\r\n" +
				"Jar, you can use the --cryptedstagers switch to remove unused code from the\r\n" +
				"Stager base class.");
	}

	public Parameter getExtraArg() {
		return new Parameter("CRYPTER", false, Parameter.TYPE_ANY, "Crypter to crypt the stager with");
	}

	public Parameter[] getParameters() {
		return new Parameter[0];
	}

	public boolean isDynstagerUsableWith(DynStagerHandler[] dynstagers) {
		for (int i = 0; i < dynstagers.length; i++) {
			if (dynstagers[i] instanceof Integrated || dynstagers[i] instanceof LocalStage)
				return false;
		}
		return true;
	}

	public String getTestExtraArg() {
		return "RnR";
	}
}
