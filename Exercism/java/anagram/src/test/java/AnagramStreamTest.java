import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class AnagramStreamTest {


    @Test
    public void testNoMatches() {
        AnagramStream detector = new AnagramStream("diaper");

        assertThat(
                detector.match(
                        Arrays.asList("hello", "world", "zombies", "pants")))
                .isEmpty();
    }

    //    @Ignore("Remove to run test")
    @Test
    public void testDetectMultipleAnagramStreams() {
        AnagramStream detector = new AnagramStream("master");

        assertThat(detector.match(Arrays.asList("stream", "pigeon", "maters")))
                .containsExactlyInAnyOrder​("maters", "stream");
    }

    //    @Ignore("Remove to run test")
    @Test
    public void testEliminateAnagramStreamSubsets() {
        AnagramStream detector = new AnagramStream("good");

        assertThat(detector.match(Arrays.asList("dog", "goody"))).isEmpty();
    }

    //    @Ignore("Remove to run test")
    @Test
    public void testDetectLongerAnagramStream() {
        AnagramStream detector = new AnagramStream("listen");

        assertThat(
                detector.match(
                        Arrays.asList("enlists", "google", "inlets", "banana")))
                .containsExactlyInAnyOrder​("inlets");
    }

    //    @Ignore("Remove to run test")
    @Test
    public void testDetectMultipleAnagramStreamsForLongerWord() {
        AnagramStream detector = new AnagramStream("allergy");
        assertThat(
                detector.match(
                        Arrays.asList(
                                "gallery",
                                "ballerina",
                                "regally",
                                "clergy",
                                "largely",
                                "leading")))
                .containsExactlyInAnyOrder​("gallery", "regally", "largely");
    }

    //    @Ignore("Remove to run test")
    @Test
    public void testDetectsMultipleAnagramStreamsWithDifferentCase() {
        AnagramStream detector = new AnagramStream("nose");

        assertThat(detector.match(Arrays.asList("Eons", "ONES")))
                .containsExactlyInAnyOrder​("Eons", "ONES");
    }

    //    @Ignore("Remove to run test")
    @Test
    public void testEliminateAnagramStreamsWithSameChecksum() {
        AnagramStream detector = new AnagramStream("mass");

        assertThat(detector.match(Collections.singletonList("last")))
                .isEmpty();
    }

    //    @Ignore("Remove to run test")
    @Test
    public void testCaseInsensitiveWhenBothAnagramStreamAndSubjectStartWithUpperCaseLetter() {
        AnagramStream detector = new AnagramStream("Orchestra");

        assertThat(
                detector.match(
                        Arrays.asList("cashregister", "Carthorse", "radishes")))
                .containsExactlyInAnyOrder​("Carthorse");
    }

    //    @Ignore("Remove to run test")
    @Test
    public void testCaseInsensitiveWhenSubjectStartsWithUpperCaseLetter() {
        AnagramStream detector = new AnagramStream("Orchestra");

        assertThat(
                detector.match(
                        Arrays.asList("cashregister", "carthorse", "radishes")))
                .containsExactlyInAnyOrder​("carthorse");
    }

    //    @Ignore("Remove to run test")
    @Test
    public void testCaseInsensitiveWhenAnagramStreamStartsWithUpperCaseLetter() {
        AnagramStream detector = new AnagramStream("orchestra");

        assertThat(
                detector.match(
                        Arrays.asList("cashregister", "Carthorse", "radishes")))
                .containsExactlyInAnyOrder​("Carthorse");
    }

    //    @Ignore("Remove to run test")
    @Test
    public void testIdenticalWordRepeatedIsNotAnagramStream() {
        AnagramStream detector = new AnagramStream("go");

        assertThat(detector.match(Collections.singletonList("go Go GO")))
                .isEmpty();
    }

    //    @Ignore("Remove to run test")
    @Test
    public void testAnagramStreamMustUseAllLettersExactlyOnce() {
        AnagramStream detector = new AnagramStream("tapper");

        assertThat(detector.match(Collections.singletonList("patter")))
                .isEmpty();
    }

    //    @Ignore("Remove to run test")
    @Test
    public void testWordsAreNotAnagramStreamsOfThemselvesCaseInsensitive() {
        AnagramStream detector = new AnagramStream("BANANA");

        assertThat(detector.match(Arrays.asList("BANANA", "Banana", "banana")))
                .isEmpty();
    }

    //    @Ignore("Remove to run test")
    @Test
    public void testWordsOtherThanThemselvesCanBeAnagramStreams() {
        AnagramStream detector = new AnagramStream("LISTEN");

        assertThat(detector.match(Arrays.asList("Listen", "Silent", "LISTEN")))
                .containsExactlyInAnyOrder​("Silent");
    }

}
