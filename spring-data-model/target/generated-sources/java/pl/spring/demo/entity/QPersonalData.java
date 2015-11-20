package pl.spring.demo.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPersonalData is a Querydsl query type for PersonalData
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QPersonalData extends BeanPath<PersonalData> {

    private static final long serialVersionUID = 1465009817L;

    public static final QPersonalData personalData = new QPersonalData("personalData");

    public final StringPath name = createString("name");

    public final StringPath surname = createString("surname");

    public QPersonalData(String variable) {
        super(PersonalData.class, forVariable(variable));
    }

    public QPersonalData(Path<? extends PersonalData> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPersonalData(PathMetadata<?> metadata) {
        super(PersonalData.class, metadata);
    }

}

