package io.searchbox.core;

import com.github.tlrx.elasticsearch.test.annotations.ElasticsearchNode;
import com.github.tlrx.elasticsearch.test.support.junit.runners.ElasticsearchRunner;
import io.searchbox.Action;
import io.searchbox.client.JestResult;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static junit.framework.Assert.*;

/**
 * @author Dogukan Sonmez
 */

@RunWith(ElasticsearchRunner.class)
@ElasticsearchNode
public class MoreLikeThisIntegrationTest extends AbstractIntegrationTest {

    @Test
    public void moreLikeThis() {
        try {
            executeTestCase(new MoreLikeThis.Builder("1").index("twitter").type("tweet").build());
        } catch (Exception e) {
            fail("Failed during the MoreLikeThis with valid parameters. Exception:" + e.getMessage());
        }
    }

    @Test
    public void moreLikeThisWithoutQuery() {
        try {
            executeTestCase(new MoreLikeThis.Builder("1").index("twitter").type("tweet").build());
        } catch (Exception e) {
            fail("Failed during the MoreLikeThis with valid parameters. Exception:" + e.getMessage());
        }
    }

    private void executeTestCase(Action action) throws RuntimeException, IOException {
        JestResult result = client.execute(action);
        assertNotNull(result);
        assertFalse(result.isSucceeded());
    }

}
