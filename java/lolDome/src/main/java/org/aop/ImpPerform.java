package org.aop;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.logging.ErrorManager;

@Component
public class ImpPerform implements Performance{
    public ImpPerform() {
    }

    @Override
    public void perform() throws MyException {
        int random = (int)(Math.random()*100);
        if (random >50)
            System.out.println("进行了表演");
        else {
            throw new MyException("表演者生病了");
        }
    }
}
