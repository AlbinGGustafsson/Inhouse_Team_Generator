package org.example;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeech {

    public void test() {

        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

        Voice voice;
        //getting voice, here we have used kevin (male version) voice
        voice = VoiceManager.getInstance().getVoice("kevin");
        if (voice != null) {
            //the Voice class allocate() method allocates this voice
            voice.allocate();
        }
        try {
            //sets the rate (words per minute i.e. 190) of the speech
            voice.setRate(190);
            //sets the baseline pitch (150) in hertz
            voice.setPitch(150);
            //sets the volume (10) of the voice
            voice.setVolume(10);
            //the speak() method speaks the specified text
            voice.speak("snake xD");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//        try {
//            //setting properties as Kevin Dictionary
//            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us" + ".cmu_us_kal.KevinVoiceDirectory");
//            //registering speech engine
//            Central.registerEngineCentral("com.sun.speech.freetts" + ".jsapi.FreeTTSEngineCentral");
//            //create a Synthesizer that generates voice
//            Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
//            //allocates a synthesizer
//            synthesizer.allocate();
//            //resume a Synthesizer
//            synthesizer.resume();
//            //speak the specified text until the QUEUE become empty
//            synthesizer.speakPlainText("Snake XD", null);
//            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
//            //deallocating the Synthesizer
//            synthesizer.deallocate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
}

