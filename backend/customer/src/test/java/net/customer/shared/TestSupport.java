package net.customer.shared;

import org.assertj.db.type.Changes;
import org.assertj.db.type.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class TestSupport {



    private DataSource source;
    private Changes changes;

    protected JdbcTemplate jdbcTemplate;

    @Autowired
    public void setSource(DataSource source, JdbcTemplate jdbcTemplate) {
        this.source = source;
        this.changes = new Changes(this.source);
        this.jdbcTemplate = jdbcTemplate;
    }

    protected Changes createChanges() {
        return this.changes;
    }


}
