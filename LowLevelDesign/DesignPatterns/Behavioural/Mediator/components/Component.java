package Behavioural.Mediator.components;

import Behavioural.Mediator.mediator.Mediator;

public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
