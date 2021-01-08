## Micronaut 2.3.0-SNAPSHOT Documentation

- [User Guide](https://docs.micronaut.io/snapshot/guide/index.html)
- [API Reference](https://docs.micronaut.io/snapshot/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/snapshot/guide/configurationreference.html)
---

## Azure Container Instance Workflow

Workflow file: [`.github/workflows/azure-container-instance.yml`](.github/workflows/azure-container-instance.yml)

### Workflow description
For pushes to the `master` branch, the workflow will:
1. Setup the build environment with respect to the selected java/graalvm version.
1. Login to Docker registry.
1. Login to [Azure Command-Line Interface ](https://docs.microsoft.com/cs-cz/cli/azure/).
1. Build, tag and push Docker image with Micronaut application to the Docker registry.
1. Deploy to [Azure Container Instances](https://docs.microsoft.com/cs-cz/azure/container-instances/).

### Dependencies on other GitHub Actions
- [Login to Docker Registry `docker/login`](https://github.com/docker/login-action)
- [Setup GraalVM `DeLaGuardo/setup-graalvm`](https://github.com/DeLaGuardo/setup-graalvm)
- [Setup Azure CLI `azure/login`](https://github.com/Azure/login)

### Setup
Add the following GitHub secrets:

| Name | Description |
| ---- | ----------- |
| DOCKER_USERNAME | Docker registry username. In case of Azure Container Registry, provide Azure username or Service principal ID, see more on [Azure Container Registry authentication with service principals](https://docs.microsoft.com/en-us/azure/container-registry/container-registry-auth-service-principal). |
| DOCKER_PASSWORD | Docker registry password. In case of Azure Container Registry, provide Azure password or Service principal password. |
| DOCKER_REPOSITORY_PATH | Docker image repository. In case of Azure Container Registry, for image `micronaut.azurecr.io/foo/bar:0.1`, the `foo` is an _image repository_. |
| DOCKER_REGISTRY_URL | Docker registry url. In case of Azure Container Registry use the Container registry login path, e.g. for the image `micronaut.azurecr.io/foo/bar:0.1`, the `micronaut.azurecr.io` is a _registry url_. |
| AZURE_CREDENTIALS | Azure Service Principal, see more on [Azure/aci-deploy#Azure Service Principal for RBAC](https://github.com/Azure/aci-deploy#azure-service-principal-for-rbac). |
| AZURE_RESOURCE_GROUP | Azure Resource Group name, see more on [Resource groups](https://docs.microsoft.com/en-us/azure/azure-resource-manager/management/overview#resource-groups). |

The workflow file also contains additional configuration options that are now configured to:

| Name | Description | Default value |
| ---- | ----------- | ------------- |
| AZURE_LOCATION | Location where the Container Instance will be created. See [Resource availability for Azure Container Instances in Azure regions](https://docs.microsoft.com/en-us/azure//container-instances/container-instances-region-availability) to find out what regions are supported. | `westeurope` |
| AZURE_DNS_LABEL | The dns name label for container group with public IP. | `azure-container-instance-maven-test` |


### Verification
Call the rest api endpoint `[AZURE_DNS_LABEL].[AZURE_LOCATION].azurecontainer.io:[PORT]/azureContainerInstanceMavenTest`:
```
curl http://azure-container-instance-maven-test.westeurope.westeurope.azurecontainer.io:8080/azureContainerInstanceMavenTest
```

## Feature http-client documentation

- [Micronaut Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## Feature github-workflow-azure-container-instance documentation

- [https://docs.github.com/en/free-pro-team@latest/actions](https://docs.github.com/en/free-pro-team@latest/actions)

