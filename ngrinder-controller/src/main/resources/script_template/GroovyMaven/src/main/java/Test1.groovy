import static net.grinder.script.Grinder.grinder
import static org.junit.Assert.*
import static org.hamcrest.Matchers.*
import net.grinder.plugin.http.HTTPRequest
import net.grinder.script.GTest
import net.grinder.script.Grinder
import net.grinder.scriptengine.groovy.junit.GrinderRunner
import net.grinder.scriptengine.groovy.junit.annotation.BeforeThread

import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith

import HTTPClient.HTTPResponse

@RunWith(GrinderRunner)
class Test1 {

	public static GTest test;
	public static HTTPRequest request;

	@BeforeClass
	public static void beforeClass() {
		test = new GTest(1, "${project_name}");
		request = new HTTPRequest();
		test.record(request);
	}


	@BeforeThread
	public void beforeThread() {
		grinder.statistics.delayReports=true;
	}

	@Test
	public void test(){
		HTTPResponse result = request.GET("${url}");
		assertThat(result.statusCode, is(200));
	}
}
