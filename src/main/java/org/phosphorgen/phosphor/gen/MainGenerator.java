package org.phosphorgen.phosphor.gen;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;

public class MainGenerator extends ChunkGenerator {

    byte bedrock = (byte) Material.BEDROCK.getId();
    byte stone = (byte) Material.STONE.getId();

    @Override
    public byte[] generate(World world, Random random, int i, int i1) {
        byte[] b = new byte[32768];
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 0; y < 1; y++)
                    b[xyzToByte(x, y, z)] = bedrock;
                for (int y = 1; y < 15; y++)
                    b[xyzToByte(x, y, z)] = stone;
            }
        }
        return b;
    }

    public int xyzToByte(int x, int y, int z) {
        return (x * 16 + z) * 128 + y;
    }
}
