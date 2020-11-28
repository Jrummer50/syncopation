# 5yncopa7ion Report

5yncopa7ion is a Polyrhythmic Syncopation Metronome Android Mobile application allowing musicians, especially drummers, to accurately produce, internalize and practice more than two cross-beat (rhythm) polyrhythms. Most available metronomes do not offer ratio cross-beat polyrhythm functionality, eg. 3:2 (read 3 against 2), 3:4, 5:3, 5:7 etc., and the ones that do generally only offer two beat capability. For groups of musicians, or instrumentalists such as drummers, pianists and guitarists who can play multiple sounds at a time, learning polyrhythmic patterns composed of more than two rhythms would be greatly aided by this metronome. The capability of this metronome goes up to a four rhythm capability plus the primary beat and subdivision capability, which in nearly all realistic cases is more than sufficient, providing the ability to study four rhythm patterns over a disconnected primary pulse.

**Built Using**



*   Android Studio IDE
    *   Java
    *   XML
*   Reaper DAW
    *   PreSonus Studio 1824c interface
        *   mp3
    *   Roland GAIA SH-01 Synthesizer

## Implemented Features

**Complementary Custom Tonal Palette:**

The different tones for each beat and cross-beat were recorded for this project using Reaper Digital Audio Workstation, PreSonus STUDIO1824c and the Roland GAIA SH-01 Synthesizer.

**Tempo Control:**

Allows the user to choose their preferred beat speed in beats per minute (bpm). The adjustment is performed with the plus and minus buttons adjusting the tempo up and down by 1 bpm per tap or 10 bpm per held press.

**Time Signature Selection:**

Allows the user to choose the number of beats in the measure which dictates the space in which the polyrhythms would cycle.

**Sub-Division Selection:**

Allows the user to further refine the foundational grid which the polyrhythm will be contrasted against.

**Four Polyrhythm Beat Selections:**

Allows the user to choose zero to four cross-beats to produce the desired polyrhythm.

## TODO Features and Implementation

**Timer Refinement:**

The multi threading of each timer based in milliseconds instead of nanoseconds makes unison beats more of a ruff or a run of grace notes. As well the sum of milliseconds lost to mathematical rounding, compound as measures pass causing a gradual cross-beat shift. Both of these need mitigation. **-** This might be accomplished with the Java nanoTime() method.

**Tap and Swipe Tempo Control:**

The ability to tap the desired tempo or to swipe right or left to increase or decrease the tempo more rapidly, are two planned unimplemented features that would greatly improve usability.

**Polyrhythm Displacement Grid and Offset Selections:**

The ability to offset the starting point of a cross-beat and therefore also the alternate grid on which the offset is shifted is another unimplemented feature with two dependent controls that would greatly benefit users. **-** This would be accomplished with cross-beat cycle length offset grid subdivision and number of unit displacement selectors for each polyrhythm cross-beat.

**Super Division Selection:**

The final unimplemented feature, the ability to change the space length in which each cross-beat takes to cycle, which also necessitates the ability to set the subdivision grid on which the space would be contracted or expanded from the base length of the measure, allowing the user to implement fully dissociated cross-beat polyrhythms, is an innovative feature and polyrhythmic concept, which coupled with the polyrhythm displacement feature would be the highlight capabilities of the application. **-** This would be accomplished with a measure-length distortion-grid selector and a selector for unit increase or decrease from the initial measure length.
