package liveProject;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.HttpsTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testng.annotations.BeforeClass;

@Provider("UserProvider")
@PactFolder("target/Pacts")
public class ProviderTest {

    @BeforeEach
    public void setUp(PactVerificationContext context) {

        //where http test target should be sent
        HttpTestTarget target = new HttpTestTarget("localhost", 8585);
        context.setTarget(target);
    }
// Verifying the contract response
    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    public void providerTest(PactVerificationContext context) {
        context.verifyInteraction();
    }
// Trigger to Post request interaction
    @State("A request to create user")
    public void providerState() {

    }
}

