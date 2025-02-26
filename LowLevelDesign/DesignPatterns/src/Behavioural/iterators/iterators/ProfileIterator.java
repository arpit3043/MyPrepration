package Behavioural.iterators.iterators;
import Behavioural.iterators.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();
    Profile getNext();
    void reset();
}