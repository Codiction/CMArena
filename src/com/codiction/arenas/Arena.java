/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=cbase_license
 * If you do not agree to the terms refrain yourself from using this library!
 */
package com.codiction.arenas;

import com.codiction.arenas.player.ArenaPlayer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Codiction
 */
public class Arena {

    private List<ArenaPlayer> playerList = new ArrayList();

    public ArenaPlayer getPlayer(String name) {
        for (ArenaPlayer player : playerList) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

}
