/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.url;

import com.microsoft.rest.RestClient;

/**
 * The interface for AutoRestUrlTestService class.
 */
public interface AutoRestUrlTestService {
    /**
     * Gets the REST client.
     *
     * @return the {@link RestClient} object.
     */
     RestClient restClient();

    /**
     * Gets A string value 'globalItemStringPath' that appears in the path.
     *
     * @return the globalStringPath value.
     */
    String globalStringPath();

    /**
     * Sets A string value 'globalItemStringPath' that appears in the path.
     *
     * @param globalStringPath the globalStringPath value.
     * @return the service client itself
     */
    AutoRestUrlTestService withGlobalStringPath(String globalStringPath);

    /**
     * Gets should contain value null.
     *
     * @return the globalStringQuery value.
     */
    String globalStringQuery();

    /**
     * Sets should contain value null.
     *
     * @param globalStringQuery the globalStringQuery value.
     * @return the service client itself
     */
    AutoRestUrlTestService withGlobalStringQuery(String globalStringQuery);

    /**
     * Gets the Paths object to access its operations.
     * @return the Paths object.
     */
    Paths paths();

    /**
     * Gets the Queries object to access its operations.
     * @return the Queries object.
     */
    Queries queries();

    /**
     * Gets the PathItems object to access its operations.
     * @return the PathItems object.
     */
    PathItems pathItems();

}
