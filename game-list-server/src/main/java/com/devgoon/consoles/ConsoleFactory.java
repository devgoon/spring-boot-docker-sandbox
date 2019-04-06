

package com.devgoon.consoles;

/**
 * Factory pattern for loading consoles
 */
public class ConsoleFactory
{
    /**
     * TODO: Method description
     * @param consoleType
     * @return
     */
    public static Console getConsole(ConsoleType consoleType)
    {
        switch (consoleType)
        {
            case TURBOGRAPX:
                return new TurboGrapx();

            case SEGA:
                return new SegaMasterSystem();

            case NES:
                return new NES();

            default:
                throw new UnsupportedOperationException("Unknown Console.");
        }
    }
}

