/*
 * Copyright 2015-2020 Ray Fowler
 * 
 * Licensed under the GNU General Public License, Version 3 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     https://www.gnu.org/licenses/gpl-3.0.html
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rotp.model.planet;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rotp.model.empires.Empire;
import rotp.ui.util.planets.Sphere2D;
import rotp.util.Base;
import rotp.util.ColorMap;

public class PlanetType implements Base {
    private static final int MAX_SHIPS = 4;
    public static final int TERRAIN_MAX = 10000000; // number of possible terrains

    private static final HashMap<String, PlanetType> typeMap = new HashMap<>();
    public static PlanetType keyed(String s)       { return typeMap.get(s); }
    public static Collection<PlanetType> allTypes(){ return typeMap.values(); }
    public static void addType(PlanetType r)       { typeMap.put(r.key(), r); }

    public static final String NONE = "PLANET_NONE";
    public static final String RADIATED = "PLANET_RADIATED";
    public static final String ZRADIATED = "PLANET_ZRADIATED";
    public static final String WRADIATED = "PLANET_WRADIATED";
    public static final String TOXIC = "PLANET_TOXIC";
    public static final String ZTOXIC = "PLANET_ZTOXIC";
    public static final String WTOXIC = "PLANET_WTOXIC";
    public static final String INFERNO = "PLANET_INFERNO";
    public static final String ZINFERNO = "PLANET_ZINFERNO";
    public static final String WINFERNO = "PLANET_WINFERNO";
    public static final String DEAD = "PLANET_DEAD";
    public static final String ZDEAD = "PLANET_ZDEAD";
    public static final String WDEAD = "PLANET_WDEAD";
    public static final String TUNDRA = "PLANET_TUNDRA";
    public static final String ZTUNDRA = "PLANET_ZTUNDRA";
    public static final String WTUNDRA = "PLANET_WTUNDRA";
    public static final String BARREN = "PLANET_BARREN";
    public static final String ZBARREN = "PLANET_ZBARREN";
    public static final String WBARREN = "PLANET_WBARREN";
    public static final String MINIMAL = "PLANET_MINIMAL";
    public static final String ZMINIMAL = "PLANET_ZMINIMAL";
    public static final String WMINIMAL = "PLANET_WMINIMAL";
    public static final String DESERT = "PLANET_DESERT";
    public static final String ZDESERT = "PLANET_ZDESERT";
    public static final String WDESERT = "PLANET_WDESERT";
    public static final String STEPPE = "PLANET_STEPPE";
    public static final String ZSTEPPE = "PLANET_ZSTEPPE";
    public static final String WSTEPPE = "PLANET_WSTEPPE";
    public static final String ARID = "PLANET_ARID";
    public static final String ZARID = "PLANET_ZARID";
    public static final String WARID = "PLANET_WARID";
    public static final String OCEAN = "PLANET_OCEAN";
    public static final String ZOCEAN = "PLANET_ZOCEAN";
    public static final String WOCEAN = "PLANET_WOCEAN";
    public static final String JUNGLE = "PLANET_JUNGLE";
    public static final String ZJUNGLE = "PLANET_ZJUNGLE";
    public static final String WJUNGLE = "PLANET_WJUNGLE";
    public static final String TERRAN = "PLANET_TERRAN";
    public static final String ZTERRAN = "PLANET_ZTERRAN";
    public static final String WTERRAN = "PLANET_WTERRAN";

    public static final int HOSTILITY_NONE = 99;
    public static final int HOSTILITY_RADIATED = 36;
    public static final int HOSTILITY_ZRADIATED = 37;
    public static final int HOSTILITY_WRADIATED = 38;
    public static final int HOSTILITY_TOXIC = 33;
    public static final int HOSTILITY_ZTOXIC = 34;
    public static final int HOSTILITY_WTOXIC = 35;
    public static final int HOSTILITY_INFERNO = 30;
    public static final int HOSTILITY_ZINFERNO = 31;
    public static final int HOSTILITY_WINFERNO = 32;
    public static final int HOSTILITY_DEAD = 27;
    public static final int HOSTILITY_ZDEAD = 28;
    public static final int HOSTILITY_WDEAD = 29;
    public static final int HOSTILITY_TUNDRA = 24;
    public static final int HOSTILITY_ZTUNDRA = 25;
    public static final int HOSTILITY_WTUNDRA = 26;
    public static final int HOSTILITY_BARREN = 21;
    public static final int HOSTILITY_ZBARREN = 22;
    public static final int HOSTILITY_WBARREN = 23;
    public static final int HOSTILITY_MINIMAL = 18;
    public static final int HOSTILITY_ZMINIMAL = 19;
    public static final int HOSTILITY_WMINIMAL = 20;
    public static final int HOSTILITY_DESERT = 15;
    public static final int HOSTILITY_ZDESERT = 16;
    public static final int HOSTILITY_WDESERT = 17;
    public static final int HOSTILITY_STEPPE = 12;
    public static final int HOSTILITY_ZSTEPPE = 13;
    public static final int HOSTILITY_WSTEPPE = 14;
    public static final int HOSTILITY_ARID = 9;
    public static final int HOSTILITY_ZARID = 10;
    public static final int HOSTILITY_WARID = 11;
    public static final int HOSTILITY_OCEAN = 6;
    public static final int HOSTILITY_ZOCEAN = 7;
    public static final int HOSTILITY_WOCEAN = 8;
    public static final int HOSTILITY_JUNGLE = 3;
    public static final int HOSTILITY_ZJUNGLE = 4;
    public static final int HOSTILITY_WJUNGLE = 5;
    public static final int HOSTILITY_TERRAN = 0;
    public static final int HOSTILITY_ZTERRAN = 1;
    public static final int HOSTILITY_WTERRAN = 2;

    private String key;
    private String descBiological;
    private String descSilicoid;
    private String terrainKey;
    private String panoramaKey;
    private final List<Integer> terrainSeeds = new ArrayList<>();
    private final int[] shipX = new int[MAX_SHIPS];
    private final int[] shipY = new int[MAX_SHIPS];
    private final int[] shipW = new int[MAX_SHIPS];

    private final List<String> landscapeKeys  = new ArrayList<>();
    private final List<String> cloudKeys      = new ArrayList<>();
    private final List<String> atmosphereKeys = new ArrayList<>();
    private int hostility;
    private int minSize;
    private int maxSize;

    private transient ColorMap colorMap;
    private transient BufferedImage terrainImage;
    private transient BufferedImage panoramaImage;
    private transient Map<Integer, Sphere2D>smallSpheres;
    private transient Map<Integer, Integer> sphereResolution;

    private  Map<Integer,Sphere2D> smallSpheres() {
        if (smallSpheres == null)
            smallSpheres = new HashMap<>();
        return smallSpheres;
    }
    private  Map<Integer,Integer> sphereResolution() {
        if (sphereResolution == null)
            sphereResolution = new HashMap<>();
        return sphereResolution;
    }
    public Sphere2D smallSphere(Planet p)               { return smallSpheres().get(p.terrainSeed());  }
    public void smallSphere(Sphere2D sph, Planet p)     { smallSpheres().put(p.terrainSeed(), sph); }
    public int sphereResolution(Planet p)         {
        if (PlanetType.this.sphereResolution().containsKey(p.terrainSeed()))
            return PlanetType.this.sphereResolution().get(p.terrainSeed());
        else
            return 0;
    }

    public PlanetType() {
        terrainSeeds.add(roll(1,TERRAIN_MAX-1));
    }
    @Override
    public String toString()                  { return concat("PlanetType: ", key); }

    public String key()                       { return key; }
    public void key(String s)                 { key = s; }
    public String descBiological()               { return descBiological; }
    public void descBiological(String s)         { descBiological = s; }
    public String descSilicoid()               { return descSilicoid; }
    public void descSilicoid(String s)         { descSilicoid = s; }
    public int hostility()                    { return hostility; }
    public void hostility(int i)              { hostility = i; }
    public String terrainKey()                { return terrainKey; }
    public void terrainKey(String s)          { terrainKey = s; }
    public String panoramaKey()               { return panoramaKey; }
    public void panoramaKey(String s)         { panoramaKey = s; }
    public int minSize()                      { return minSize; }
    public void minSize(int i)                { minSize = i; }
    public int maxSize()                      { return maxSize; }
    public void maxSize(int i)                { maxSize = i; }
    public void landscapeKeys(String s)       { landscapeKeys.addAll(substrings(s, ',')); }
    public List<String> atmosphereKeys()      { return atmosphereKeys; }
    public List<String> cloudKeys()           { return cloudKeys; }

    public int shipX(int i)                   { return shipX[i]; }
    public void shipX(int i, int val)         { shipX[i] = val; }
    public int shipY(int i)                   { return shipY[i]; }
    public void shipY(int i, int val)         { shipY[i] = val; }
    public int shipW(int i)                   { return shipW[i]; }
    public void shipW(int i, int val)         { shipW[i] = val; }

    public void cloudKeys(String s) {
        cloudKeys.clear();
        if (!s.trim().isEmpty())
            cloudKeys.addAll(substrings(s, ','));
    }
    public void atmosphereKeys(String s) {
        atmosphereKeys.clear();
        if (!s.trim().isEmpty())
            atmosphereKeys.addAll(substrings(s, ','));
    }

    public String name()                      { return text(key); }
    public boolean hostileToTerrans()         { return hostility >= HOSTILITY_BARREN; }
    public int randomTerrainSeed()            { return random(terrainSeeds); }

    public boolean isAsteroids()              { return key.equals(NONE); }

    public String description(Empire emp) {
        if (emp.ignoresPlanetEnvironment())
            return descSilicoid();
        else
            return descBiological();
    }
    public BufferedImage terrainImage()           {
        if (terrainImage == null)
            terrainImage = newBufferedImage(currentFrame(terrainKey));
        return terrainImage;
    }
    public BufferedImage panoramaImage()           {
        if (panoramaKey == null)
            return null;
        if (panoramaImage == null)
            panoramaImage = newBufferedImage(currentFrame(panoramaKey));
        return panoramaImage;
    }
    public String randomLandscapeKey() {
        return random(landscapeKeys);
    }
    public Image randomCloudImage() {
        return cloudKeys.isEmpty() ? null : image(random(cloudKeys));
    }
    public Image atmosphereImage() {
        return atmosphereKeys.isEmpty() ? null : image(atmosphereKeys.get(0));
    }
    public int randomSize() {
        return 5* roll(minSize()/5, maxSize()/5);
    }
    public ColorMap colorMap()  {
        if (colorMap == null)
            colorMap = new ColorMap();
        return colorMap;
    }
    public float randomOceanPct() {
        switch(key()) {
            case PlanetType.OCEAN:
                return random(0.8f,1.0f);
            case PlanetType.ZOCEAN:
                return random(0.8f,1.0f);
            case PlanetType.WOCEAN:
                return random(0.8f,1.0f);
            case PlanetType.JUNGLE:
                return random(0.6f,0.8f);
            case PlanetType.ZJUNGLE:
                return random(0.6f,0.8f);
            case PlanetType.WJUNGLE:
                return random(0.6f,0.8f);
            case PlanetType.TERRAN:
                return random(0.55f,0.7f);
            case PlanetType.ZTERRAN:
                return random(0.55f,0.7f);
            case PlanetType.WTERRAN:
                return random(0.55f,0.7f);
            case PlanetType.STEPPE:
                return random(0.25f,0.55f);
            case PlanetType.ZSTEPPE:
                return random(0.25f,0.55f);
            case PlanetType.WSTEPPE:
                return random(0.25f,0.55f);
            case PlanetType.ARID:
                return random(0.1f,0.25f);
            case PlanetType.ZARID:
                return random(0.1f,0.25f);
            case PlanetType.WARID:
                return random(0.1f,0.25f);
            case PlanetType.DESERT:
                return random(0.05f,0.1f);
            case PlanetType.ZDESERT:
                return random(0.05f,0.1f);
            case PlanetType.WDESERT:
                return random(0.05f,0.1f);
            case PlanetType.MINIMAL:
                return 0.05f;
            case PlanetType.ZMINIMAL:
                return 0.05f;
            case PlanetType.WMINIMAL:
                return 0.05f;
            case PlanetType.TOXIC:
                return random(0.2f,0.6f);
            case PlanetType.ZTOXIC:
                return random(0.2f,0.6f);
            case PlanetType.WTOXIC:
                return random(0.2f,0.6f);
            case PlanetType.BARREN:
            case PlanetType.ZBARREN:
            case PlanetType.WBARREN:
            case PlanetType.TUNDRA:
            case PlanetType.ZTUNDRA:
            case PlanetType.WTUNDRA:
            case PlanetType.DEAD:
            case PlanetType.ZDEAD:
            case PlanetType.WDEAD:
            case PlanetType.INFERNO:
            case PlanetType.ZINFERNO:
            case PlanetType.WINFERNO:
            case PlanetType.RADIATED:
            case PlanetType.ZRADIATED:
            case PlanetType.WRADIATED:
            default:
                return 0.0f;
        }
    }
    public int randomIceLevel() {
        switch(key()) {
            case PlanetType.OCEAN:
                return roll(10,30);
            case PlanetType.ZOCEAN:
                return roll(10,30);
            case PlanetType.WOCEAN:
                return roll(10,30);
            case PlanetType.JUNGLE:
                return 0;
            case PlanetType.ZJUNGLE:
                return 0;
            case PlanetType.WJUNGLE:
                return 0;
            case PlanetType.TERRAN:
                return roll(10,60);
            case PlanetType.ZTERRAN:
                return roll(10,60);
            case PlanetType.WTERRAN:
                return roll(10,60);
            case PlanetType.STEPPE:
                return roll(10,80);
            case PlanetType.ZSTEPPE:
                return roll(10,80);
            case PlanetType.WSTEPPE:
                return roll(10,80);
            case PlanetType.ARID:
                return roll(10,60);
            case PlanetType.ZARID:
                return roll(10,60);
            case PlanetType.WARID:
                return roll(10,60);
            case PlanetType.DESERT:
                return roll(10,50);
            case PlanetType.ZDESERT:
                return roll(10,50);
            case PlanetType.WDESERT:
                return roll(10,50);
            case PlanetType.MINIMAL:
                return roll(0,40);
            case PlanetType.ZMINIMAL:
                return roll(0,40);
            case PlanetType.WMINIMAL:
                return roll(0,40);
            case PlanetType.BARREN:
                return roll(0,20);
            case PlanetType.ZBARREN:
                return roll(0,20);
            case PlanetType.WBARREN:
                return roll(0,20);
            case PlanetType.TUNDRA:
                return 0;
            case PlanetType.ZTUNDRA:
                return 0;
            case PlanetType.WTUNDRA:
                return 0;
            case PlanetType.DEAD:
                return roll(30,100);
            case PlanetType.ZDEAD:
                return roll(30,100);
            case PlanetType.WDEAD:
                return roll(30,100);
            case PlanetType.INFERNO:
                return 0;
            case PlanetType.ZINFERNO:
                return 0;
            case PlanetType.WINFERNO:
                return 0;
            case PlanetType.TOXIC:
                return roll(0,30);
            case PlanetType.ZTOXIC:
                return roll(0,30);
            case PlanetType.WTOXIC:
                return roll(0,30);
            case PlanetType.RADIATED:
            case PlanetType.ZRADIATED:
            case PlanetType.WRADIATED:
            default:
                return  roll(0,20);
        }
    }
    public int randomCloudThickness() {
        // inferno 600+
        // none = 0
        // wisps = 300-350
        // thin 350-400
        // terran 400-450
        // heavy 450-500
        switch(key()) {
            case PlanetType.OCEAN:
            case PlanetType.ZOCEAN:
            case PlanetType.WOCEAN:
            case PlanetType.JUNGLE:
            case PlanetType.ZJUNGLE:
            case PlanetType.WJUNGLE:
            case PlanetType.TERRAN:
            case PlanetType.ZTERRAN:
            case PlanetType.WTERRAN:
            case PlanetType.STEPPE:
                return roll(400,450);
            case PlanetType.ZSTEPPE:
                return roll(400,450);
            case PlanetType.WSTEPPE:
                return roll(400,450);
            case PlanetType.ARID:
            case PlanetType.ZARID:
            case PlanetType.WARID:
            case PlanetType.DESERT:
            case PlanetType.ZDESERT:
            case PlanetType.WDESERT:
            case PlanetType.TUNDRA:
                return roll(350,400);
            case PlanetType.ZTUNDRA:
                return roll(350,400);
            case PlanetType.WTUNDRA:
                return roll(350,400);
            case PlanetType.MINIMAL:
            case PlanetType.ZMINIMAL:
            case PlanetType.WMINIMAL:
            case PlanetType.BARREN:
                return roll(300,350);
            case PlanetType.ZBARREN:
                return roll(300,350);
            case PlanetType.WBARREN:
                return roll(300,350);
            case PlanetType.INFERNO:
                return 700;
            case PlanetType.ZINFERNO:
                return 700;
            case PlanetType.WINFERNO:
                return 700;
            case PlanetType.TOXIC:
                return roll(300,500);
            case PlanetType.ZTOXIC:
                return roll(300,500);
            case PlanetType.WTOXIC:
                return roll(300,500);
            case PlanetType.DEAD:
            case PlanetType.ZDEAD:
            case PlanetType.WDEAD:
            case PlanetType.RADIATED:
            case PlanetType.ZRADIATED:
            case PlanetType.WRADIATED:
            default:
                return  0;
        }
    }
}
