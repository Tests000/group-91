package repository.getters;

import java.io.InputStream;
import java.util.*;
import java.util.logging.Logger;

public class ReaderList extends GetterList {

    private final Logger logger;

    public ReaderList(Logger logger) {
        this.logger = logger;
    }

    @Override
    protected int nextInt() throws InputMismatchException {
        return ReaderInteger.nextInt();
    }


    @Override
    protected void fillList(List<Integer> answers) {
        try {
            saveAnswers(answers);
        } catch (InputMismatchException e) {
            logger.info("Некорректные данные");
            saveAnswers(answers);
        }
    }
}
