

package com.devgoon.consoles;

/**
 * Factory pattern for loading consoles
 */
public class ConsoleFactory
{
    /**
     * Console Factory
     * @param consoleType
     * @return
     */
    public static Console getConsole(ConsoleType consoleType)
    {
        switch (consoleType)
        {
            case TURBOGRAFX:
                return new TurboGrafx();

            case SEGA:
                return new SegaMasterSystem();

            case NES:
                return new NES();

            default:
                throw new UnsupportedOperationException("Unknown console.");
        }
    }
}

