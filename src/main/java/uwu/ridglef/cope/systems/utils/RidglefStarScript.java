package uwu.ridglef.cope.systems.utils;

import meteordevelopment.meteorclient.utils.misc.MeteorStarscript;
import meteordevelopment.starscript.value.Value;
import meteordevelopment.starscript.value.ValueMap;

public class RidglefStarScript {
    public static Value ver(){
        return Value.string(Stats.Version);
    }

    public static void init(){
        MeteorStarscript.ss.set("ridglef", new ValueMap()
            .set("version", RidglefStarScript::ver));
    }
}
