/*
 * Copyright (c) 2006-2015 DMDirc Developers
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

package com.dmdirc.parser.events;

import com.dmdirc.parser.interfaces.ChannelClientInfo;
import com.dmdirc.parser.interfaces.ChannelInfo;
import com.dmdirc.parser.interfaces.Parser;

import java.time.LocalDateTime;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Called when a person is kicked.
 */
public class ChannelKickEvent extends ParserEvent {

    private final ChannelInfo channel;
    private final ChannelClientInfo kickedClient;
    private final ChannelClientInfo client;
    private final String reason;
    private final String host;

    public ChannelKickEvent(final Parser parser, final LocalDateTime date, final ChannelInfo channel,
            final ChannelClientInfo kickedClient, final ChannelClientInfo client,
            final String reason, final String host) {
        super(parser, date);
        this.channel = checkNotNull(channel);
        this.kickedClient = checkNotNull(kickedClient);
        this.client = checkNotNull(client);
        this.reason = checkNotNull(reason);
        this.host = checkNotNull(host);
    }

    public ChannelInfo getChannel() {
        return channel;
    }

    public ChannelClientInfo getKickedClient() {
        return kickedClient;
    }

    public ChannelClientInfo getClient() {
        return client;
    }

    public String getReason() {
        return reason;
    }

    public String getHost() {
        return host;
    }
}