package doa;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImp implements IDao{
    @Override
    public double getValue() {
        System.out.println("version capture");
        return 10;
    }
}
