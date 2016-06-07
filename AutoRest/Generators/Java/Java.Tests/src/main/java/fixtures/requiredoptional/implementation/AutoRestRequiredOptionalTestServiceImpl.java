/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.requiredoptional.implementation;

import fixtures.requiredoptional.AutoRestRequiredOptionalTestService;
import fixtures.requiredoptional.Implicits;
import fixtures.requiredoptional.Explicits;
import com.microsoft.rest.ServiceClient;
import com.microsoft.rest.RestClient;

/**
 * Initializes a new instance of the AutoRestRequiredOptionalTestService class.
 */
public final class AutoRestRequiredOptionalTestServiceImpl extends ServiceClient implements AutoRestRequiredOptionalTestService {

    /** number of items to skip. */
    private String requiredGlobalPath;

    /**
     * Gets number of items to skip.
     *
     * @return the requiredGlobalPath value.
     */
    public String requiredGlobalPath() {
        return this.requiredGlobalPath;
    }

    /**
     * Sets number of items to skip.
     *
     * @param requiredGlobalPath the requiredGlobalPath value.
     * @return the service client itself
     */
    public AutoRestRequiredOptionalTestServiceImpl withRequiredGlobalPath(String requiredGlobalPath) {
        this.requiredGlobalPath = requiredGlobalPath;
        return this;
    }

    /** number of items to skip. */
    private String requiredGlobalQuery;

    /**
     * Gets number of items to skip.
     *
     * @return the requiredGlobalQuery value.
     */
    public String requiredGlobalQuery() {
        return this.requiredGlobalQuery;
    }

    /**
     * Sets number of items to skip.
     *
     * @param requiredGlobalQuery the requiredGlobalQuery value.
     * @return the service client itself
     */
    public AutoRestRequiredOptionalTestServiceImpl withRequiredGlobalQuery(String requiredGlobalQuery) {
        this.requiredGlobalQuery = requiredGlobalQuery;
        return this;
    }

    /** number of items to skip. */
    private int optionalGlobalQuery;

    /**
     * Gets number of items to skip.
     *
     * @return the optionalGlobalQuery value.
     */
    public int optionalGlobalQuery() {
        return this.optionalGlobalQuery;
    }

    /**
     * Sets number of items to skip.
     *
     * @param optionalGlobalQuery the optionalGlobalQuery value.
     * @return the service client itself
     */
    public AutoRestRequiredOptionalTestServiceImpl withOptionalGlobalQuery(int optionalGlobalQuery) {
        this.optionalGlobalQuery = optionalGlobalQuery;
        return this;
    }

    /**
     * The Implicits object to access its operations.
     */
    private Implicits implicits;

    /**
     * Gets the Implicits object to access its operations.
     * @return the Implicits object.
     */
    public Implicits implicits() {
        return this.implicits;
    }

    /**
     * The Explicits object to access its operations.
     */
    private Explicits explicits;

    /**
     * Gets the Explicits object to access its operations.
     * @return the Explicits object.
     */
    public Explicits explicits() {
        return this.explicits;
    }

    /**
     * Initializes an instance of AutoRestRequiredOptionalTestService client.
     */
    public AutoRestRequiredOptionalTestServiceImpl() {
        this("http://localhost");
    }

    /**
     * Initializes an instance of AutoRestRequiredOptionalTestService client.
     *
     * @param baseUrl the base URL of the host
     */
    public AutoRestRequiredOptionalTestServiceImpl(String baseUrl) {
        super(baseUrl);
        initialize();
    }

    /**
     * Initializes an instance of AutoRestRequiredOptionalTestService client.
     *
     * @param restClient the pre-configured {@link RestClient} object
     */
    public AutoRestRequiredOptionalTestServiceImpl(RestClient restClient) {
        super(restClient);
        initialize();
    }

    private void initialize() {
        this.implicits = new ImplicitsImpl(restClient().retrofit(), this);
        this.explicits = new ExplicitsImpl(restClient().retrofit(), this);
    }
}
