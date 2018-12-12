package demo.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * 关掉Mybatis所有查询的一级缓存
 * Created by mumubin 2017/4/13.
 */
@Intercepts(@Signature(method = "query", type = Executor.class, args = {MappedStatement.class, Object.class,
        RowBounds.class, ResultHandler.class}))
public class FlushCacheInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        MappedStatement copy = copyMappedStatementFlushCache(mappedStatement);
        invocation.getArgs()[0] = copy;
        return invocation.proceed();
    }

    /**
     * 复制MappedStatement 并设置FlushCache=true
     * @param mappedStatement
     * @return
     */
    private MappedStatement copyMappedStatementFlushCache(MappedStatement mappedStatement) {
        MappedStatement.Builder builder = new MappedStatement.Builder(mappedStatement.getConfiguration(),
                mappedStatement.getId(), mappedStatement.getSqlSource(), mappedStatement.getSqlCommandType());
        builder.resource(mappedStatement.getResource());
        builder.fetchSize(mappedStatement.getFetchSize());
        builder.statementType(mappedStatement.getStatementType());
        builder.keyGenerator(mappedStatement.getKeyGenerator());
//        builder.keyProperty(mappedStatement.getKeyProperties());
        builder.timeout(mappedStatement.getTimeout());
        builder.resultMaps(mappedStatement.getResultMaps());
        builder.resultSetType(mappedStatement.getResultSetType());
        builder.cache(mappedStatement.getCache());
        builder.useCache(mappedStatement.isUseCache());
        builder.parameterMap(mappedStatement.getParameterMap());
        builder.flushCacheRequired(true);
        return builder.build();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}