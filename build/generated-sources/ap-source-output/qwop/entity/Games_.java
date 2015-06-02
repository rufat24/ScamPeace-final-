package qwop.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2014-10-16T19:58:25")
@StaticMetamodel(Games.class)
public class Games_ { 

    public static volatile SingularAttribute<Games, Long> id;
    public static volatile SingularAttribute<Games, String> gamename;
    public static volatile SingularAttribute<Games, Long> ad_id;
    public static volatile SingularAttribute<Games, Integer> players;
    public static volatile SingularAttribute<Games, Integer> winumber;
    public static volatile SingularAttribute<Games, Integer> jackpot;

}