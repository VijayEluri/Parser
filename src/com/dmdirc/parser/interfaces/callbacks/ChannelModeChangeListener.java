/*
 * Copyright (c) 2006-2014 DMDirc Developers
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.dmdirc.parser.interfaces.callbacks;

import com.dmdirc.parser.interfaces.ChannelClientInfo;
import com.dmdirc.parser.interfaces.ChannelInfo;
import com.dmdirc.parser.interfaces.FakableArgument;
import com.dmdirc.parser.interfaces.FakableSource;
import com.dmdirc.parser.interfaces.Parser;
import com.dmdirc.parser.interfaces.SpecificCallback;
import com.dmdirc.parser.irc.processors.ProcessMode;

import java.util.Date;

/**
 * Called when the channel modes are changed or discovered.
 * cChannelClient is null if the modes were found from raw 324 (/MODE #Chan reply) or if a server set the mode.<br>
 * If a Server set the mode, sHost is the servers name, else it is the full host of the user who set it
 */
@SpecificCallback
public interface ChannelModeChangeListener extends CallbackInterface {

    /**
     * Called when the channel modes are changed or discovered.
     * cChannelClient is null if the modes were found from raw 324 (/MODE #Chan reply) or if a server set the mode.<br>
     * If a Server set the mode, sHost is the servers name, else it is the full host of the user who set it
     *
     * @param parser Reference to the parser object that made the callback.
     * @param date The date/time at which the event occured
     * @param channel Channel where modes were changed
     * @param client Client chaning the modes (null if server)
     * @param host Host doing the mode changing (User host or server name)
     * @param modes String showing the exact mode change parsed.
     * @see ProcessMode#callChannelModeChanged
     */
    void onChannelModeChanged(@FakableSource Parser parser, Date date,
            @FakableSource ChannelInfo channel,
            @FakableArgument ChannelClientInfo client,
            @FakableSource String host,
            String modes);
}
