/*
 * Java Payloads.
 * 
 * Copyright (c) 2010, 2011 Michael 'mihi' Schierl
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

package javapayload.handler.stager;

import java.io.PrintStream;

import javapayload.handler.stage.StageHandler;

public abstract class DynStagerHandlerHelper extends StagerHandler {

	protected DynStagerHandlerHelper(Class handlerClassName, String summary,  boolean handlerUsable, boolean targetUsable, String description) {
		super(handlerClassName, summary, handlerUsable, targetUsable, description);
	}
	
	private StagerHandler stagerHandler;

	void setStagerHandler(StagerHandler stagerHandler) {
		this.stagerHandler = stagerHandler;
	}

	protected boolean prepare(String[] parametersToPrepare) throws Exception {
		return stagerHandler.prepare(parametersToPrepare);
	}

	protected boolean canHandleExtraArg(Class argType) {
		return stagerHandler.canHandleExtraArg(argType);
	}

	protected final void handle(StageHandler stageHandler, String[] parameters, PrintStream errorStream, Object extraArg, StagerHandler readyHandler) throws Exception {
		stagerHandler.originalParameters = originalParameters;
		handleDyn(stageHandler, parameters, errorStream, extraArg, readyHandler);
	}

	protected void handleDyn(StageHandler stageHandler, String[] parameters, PrintStream errorStream, Object extraArg, StagerHandler readyHandler) throws Exception {
		stagerHandler.handle(stageHandler, parameters, errorStream, extraArg, readyHandler);
	}

	protected boolean needHandleBeforeStart() {
		return stagerHandler.needHandleBeforeStart();
	}

	protected String[] getTestArgumentArrayHelper() {
		return stagerHandler.getTestArgumentArray();
	}
}
