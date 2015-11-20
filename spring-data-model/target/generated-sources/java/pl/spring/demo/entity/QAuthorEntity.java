package pl.spring.demo.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAuthorEntity is a Querydsl query type for AuthorEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAuthorEntity extends EntityPathBase<AuthorEntity> {

    private static final long serialVersionUID = 1608137181L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAuthorEntity authorEntity = new QAuthorEntity("authorEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPersonalData personalData;

    public QAuthorEntity(String variable) {
        this(AuthorEntity.class, forVariable(variable), INITS);
    }

    public QAuthorEntity(Path<? extends AuthorEntity> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAuthorEntity(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAuthorEntity(PathMetadata<?> metadata, PathInits inits) {
        this(AuthorEntity.class, metadata, inits);
    }

    public QAuthorEntity(Class<? extends AuthorEntity> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.personalData = inits.isInitialized("personalData") ? new QPersonalData(forProperty("personalData")) : null;
    }

}

