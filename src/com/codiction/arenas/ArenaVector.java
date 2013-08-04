/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=cbase_license
 * If you do not agree to the terms refrain yourself from using this library!
 */
package com.codiction.arenas;

/**
 *
 * @author Codiction
 */
public class ArenaVector {

    private int x;
    private int y;
    private int z;

    public ArenaVector(int x, int y, int z) {
        this.x = x;
        this.z = z;
        this.y = y;
    }

    public boolean isInAABB(ArenaVector min, ArenaVector max) {
        return ((this.x <= max.x) && (this.x >= min.x) && (this.z <= max.z) && (this.z >= min.z) && (this.y <= max.y) && (this.y >= min.y));

    }
}
