/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */  

package org.apache.ftpserver.command;

import java.io.IOException;

import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.interfaces.FtpIoSession;
import org.apache.ftpserver.interfaces.FtpServerContext;
import org.apache.ftpserver.util.FtpReplyUtil;

/**
 * <code>STAT [&lt;SP&gt; &lt;pathname&gt;] &lt;CRLF&gt;</code><br>
 *
 * This command shall cause a status response to be sent over
 * the control connection in the form of a reply.
 */
public 
class STAT extends AbstractCommand {

    /**
     * Execute command
     */
    public void execute(FtpIoSession session, 
                        FtpServerContext context,
                        FtpRequest request) throws IOException {
        
        // reset state variables
        session.resetState();
        
        // write the status info
        session.write(FtpReplyUtil.translate(session, request, context, FtpReply.REPLY_211_SYSTEM_STATUS_REPLY, "STAT", null)); 
    }
    
}
