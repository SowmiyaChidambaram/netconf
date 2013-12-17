package org.opendaylight.controller.sal.restconf.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.opendaylight.yangtools.yang.model.api.DataSchemaNode;
import org.opendaylight.yangtools.yang.model.api.Module;

public abstract class YangAndXmlAndDataSchemaLoader {

    protected static Set<Module> modules;
    protected static DataSchemaNode dataSchemaNode;
    protected static String searchedModuleName;
    protected static String searchedDataSchemaName;
    protected static String schemaNodePath;

    protected static void dataLoad(String yangPath) {
        dataLoad(yangPath, 1, null, null);
    }

    protected static void dataLoad(String yangPath, int modulesNumber, String moduleName, String dataSchemaName) {
        modules = TestUtils.resolveModulesFrom(yangPath);
        assertEquals(modulesNumber, modules.size());
        Module module = TestUtils.resolveModule(moduleName, modules);
        searchedModuleName = module == null ? "" : module.getName();
        assertNotNull(module);
        dataSchemaNode = TestUtils.resolveDataSchemaNode(dataSchemaName, module);
        searchedDataSchemaName = dataSchemaNode == null ? "" : dataSchemaNode.getQName().getLocalName();
        assertNotNull(dataSchemaNode);
        schemaNodePath = searchedModuleName + ":" + searchedDataSchemaName;
    }

}
