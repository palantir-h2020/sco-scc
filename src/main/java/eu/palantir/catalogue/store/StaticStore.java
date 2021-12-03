package eu.palantir.catalogue.store;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import eu.palantir.catalogue.dto.SecurityCapabilityDetailsDto;
import eu.palantir.catalogue.dto.billing.SCBillingSLADto;
import eu.palantir.catalogue.dto.integrity.SCIntegrityDto;
import eu.palantir.catalogue.dto.privacy.SCPrivacyDto;
import eu.palantir.catalogue.dto.security.SCSecurityDto;
import eu.palantir.catalogue.dto.vnf.VnfDescriptorsDto;
import eu.palantir.catalogue.dto.vnf.VnfSecurityGroupRuleDto;
import eu.palantir.catalogue.dto.vnf.VnfSoftwareImageDescriptionDto;
import eu.palantir.catalogue.model.billing.BillingModelType;
import eu.palantir.catalogue.model.integrity.CheckSum;
import eu.palantir.catalogue.model.network.EtherType;
import eu.palantir.catalogue.model.network.TrafficDirection;
import eu.palantir.catalogue.model.network.TransportProtocol;
import eu.palantir.catalogue.model.security.PalantirDeploymentModel;
import eu.palantir.catalogue.model.virtualization.ContainerFormat;
import eu.palantir.catalogue.model.virtualization.DiskFormat;

// TO BE REPLACED WITH DB DURING INTEGRATION. Mock only.
@ApplicationScoped
public class StaticStore {

    private SecurityCapabilityDetailsDto defaultSC;

    private SecurityCapabilityDetailsDto scOne;

    private SecurityCapabilityDetailsDto scTwo;

    // Create some static data to work with...
    public StaticStore() {
        UUID idDefault = UUID.fromString("6932e42f-4d37-4752-aca3-f6e2d500fceb");

        String imgIDDefault = "registry.my.def:latest";
        String imgNameDefault = "imgNameDef";
        String imgVersionDefault = "1.0.1";

        CheckSum checksumDefault = new CheckSum("sha-256",
                "e1af2bbb505e0a9fd03721cdbada1623a2cb7f680da6d2e2d1e38d19bd8bdfd3");
        URI imageURIDefault = URI.create("https://www.example.net/myimagedef");
        ContainerFormat containerFormatDefault = ContainerFormat.DOCKER;
        DiskFormat diskFormatDefault = DiskFormat.RAW;
        Integer minDiskDefault = 2048;
        Float minRamDefault = (float) 1024.0;
        Integer sizeDefault = 256;
        String operatingSystemDefault = "Linux 5.2";
        List<String> virtualizationEnvironmentDefault = new ArrayList<String>();

        VnfSoftwareImageDescriptionDto softwareImageDescription = new VnfSoftwareImageDescriptionDto(imgIDDefault,
                imgNameDefault, imgVersionDefault,
                checksumDefault,
                imageURIDefault,
                containerFormatDefault, diskFormatDefault, minDiskDefault, minRamDefault, sizeDefault,
                operatingSystemDefault,
                virtualizationEnvironmentDefault);

        String scGroupId = "scGroup";
        String scGroupDesc = "Default SC Security group";
        TrafficDirection direction = TrafficDirection.INGRESS;
        EtherType etherType = EtherType.IP_V4;
        TransportProtocol protocol = TransportProtocol.TCP;
        Integer minPort = 20;
        Integer maxPort = 9000;

        VnfSecurityGroupRuleDto securityGroupRule = new VnfSecurityGroupRuleDto(
                scGroupId,
                scGroupDesc, direction, etherType,
                protocol, minPort, maxPort);

        String providerDefault = "MyProviderDefault";
        String version = "1.0";
        String softwareVersionDefault = "1.0.1";
        String productInfoNameDefault = "NO INFO";
        String productInfoDescription = "ME";

        VnfDescriptorsDto vnfDefault = new VnfDescriptorsDto(
                idDefault, providerDefault, version, softwareVersionDefault, productInfoNameDefault,
                productInfoDescription, securityGroupRule, softwareImageDescription);

        List<PalantirDeploymentModel> deploymentModels = new ArrayList<PalantirDeploymentModel>();
        deploymentModels.add(PalantirDeploymentModel.CLOUD);

        List<String> detectionMethods = new ArrayList<String>();
        detectionMethods.add("netflow_monitoring");

        List<String> mitigationMethods = new ArrayList<String>();
        mitigationMethods.add("network_flow_filtering");

        List<String> controlDataTypes = new ArrayList<String>();
        controlDataTypes.add("netflow_configuration");

        List<String> monitorDataTypes = new ArrayList<String>();
        monitorDataTypes.add("pcap");

        List<String> threatProtections = new ArrayList<String>();
        threatProtections.add("ddos");

        SCSecurityDto scSecDefault = new SCSecurityDto(deploymentModels, detectionMethods, mitigationMethods,
                controlDataTypes, monitorDataTypes, threatProtections);

        List<BillingModelType> billingModelDefault = new ArrayList<BillingModelType>();
        billingModelDefault.add(BillingModelType.HOURLY);
        billingModelDefault.add(BillingModelType.INSTANCE);
        billingModelDefault.add(BillingModelType.SUBSCRIPTION);
        Float subscriptionBilling = (float) 2.0;
        Float instanceBilling = (float) 2.0;
        Float hourlyBilling = (float) 2.0;
        Integer slaDowntime = 1;
        Float slaViolationFee = (float) 20.0;
        SCBillingSLADto scBillSLADefault = new SCBillingSLADto(billingModelDefault, subscriptionBilling,
                instanceBilling,
                hourlyBilling, slaDowntime, slaViolationFee);

        String scHashDefault = "string";
        SCIntegrityDto scIntDefault = new SCIntegrityDto(scHashDefault);

        Boolean sharesData = true;
        Boolean storesData = true;
        Boolean processesData = true;
        SCPrivacyDto scPrivDefault = new SCPrivacyDto(sharesData, storesData, processesData);

        this.defaultSC = new SecurityCapabilityDetailsDto(
                idDefault, vnfDefault, scSecDefault,
                scBillSLADefault, scIntDefault, scPrivDefault);
        /////////////////////////////////////////////////////////////////////////////////////////////////
        UUID idOne = UUID.fromString("fc83e9a0-2ed5-4c23-b6da-62513953233b");

        String imgIDOne = "registry.my.def:latest";
        String imgNameOne = "imgNameDef";
        String imgVersionOne = "1.0.1";

        CheckSum checksumOne = new CheckSum("sha-256",
                "e1af2bbb505e0a9fd03721cdbada1623a2cb7f680da6d2e2d1e38d19bd8bdfd3");
        URI imageURIOne = URI.create("https://www.example.net/myimagedef");
        ContainerFormat containerFormatOne = ContainerFormat.DOCKER;
        DiskFormat diskFormatOne = DiskFormat.RAW;
        Integer minDiskOne = 2048;
        Float minRamOne = (float) 1024.0;
        Integer sizeOne = 256;
        String operatingSystemOne = "Linux 5.2";
        List<String> virtualizationEnvironmentOne = new ArrayList<String>();

        VnfSoftwareImageDescriptionDto softwareImageDescriptionOne = new VnfSoftwareImageDescriptionDto(imgIDOne,
                imgNameOne, imgVersionOne,
                checksumOne,
                imageURIOne,
                containerFormatOne, diskFormatOne, minDiskOne, minRamOne, sizeOne,
                operatingSystemOne,
                virtualizationEnvironmentOne);

        String providerOne = "MyProviderOne";
        String softwareVersionOne = "1.0.1";
        String productInfoNameOne = "NO INFO";

        VnfDescriptorsDto vnfOne = new VnfDescriptorsDto(
                idOne, providerOne, version, softwareVersionOne, productInfoNameOne,
                productInfoDescription, securityGroupRule, softwareImageDescriptionOne);

        List<PalantirDeploymentModel> deploymentModelsOne = new ArrayList<PalantirDeploymentModel>();
        deploymentModelsOne.add(PalantirDeploymentModel.CLOUD);

        List<String> detectionMethodsOne = new ArrayList<String>();
        detectionMethodsOne.add("netflow_monitoring");

        List<String> mitigationMethodsOne = new ArrayList<String>();
        mitigationMethodsOne.add("network_flow_filtering");

        List<String> controlDataTypesOne = new ArrayList<String>();
        controlDataTypesOne.add("netflow_configuration");

        List<String> monitorDataTypesOne = new ArrayList<String>();
        monitorDataTypesOne.add("pcap");

        List<String> threatProtectionsOne = new ArrayList<String>();
        threatProtectionsOne.add("ddos");

        SCSecurityDto scSecOne = new SCSecurityDto(
                deploymentModelsOne,
                detectionMethodsOne,
                mitigationMethodsOne,
                controlDataTypesOne, monitorDataTypesOne, threatProtectionsOne);

        List<BillingModelType> billingModelOne = new ArrayList<BillingModelType>();
        billingModelOne.add(BillingModelType.HOURLY);
        billingModelOne.add(BillingModelType.INSTANCE);
        billingModelOne.add(BillingModelType.SUBSCRIPTION);

        SCBillingSLADto scBillSLAOne = new SCBillingSLADto(billingModelOne, subscriptionBilling,
                instanceBilling,
                hourlyBilling, slaDowntime, slaViolationFee);

        String scHashOne = "string";
        SCIntegrityDto scIntOne = new SCIntegrityDto(scHashOne);

        Boolean sharesDataOne = true;
        Boolean storesDataOne = true;
        Boolean processesDataOne = true;
        SCPrivacyDto scPrivOne = new SCPrivacyDto(sharesDataOne, storesDataOne, processesDataOne);

        this.scOne = new SecurityCapabilityDetailsDto(
                idOne, vnfOne, scSecOne,
                scBillSLAOne, scIntOne, scPrivOne);
        /////////////////////////////////////////////////////////////////////////////////////////////////

        UUID idTwo = UUID.fromString("ee4efa39-28c6-4657-afbd-103ad588b255");

        String imgIDTwo = "registry.my.:latest";
        String imgNameTwo = "imgNameDef";
        String imgVersionTwo = "1.0.1";

        CheckSum checksumTwo = new CheckSum("sha-256",
                "e1af2bbb505e0a9fd03721cdbada1623a2cb7f680da6d2e2d1e38d19bd8bdfd3");
        URI imageURITwo = URI.create("https://www.example.net/myimagedef");
        ContainerFormat containerFormatTwo = ContainerFormat.DOCKER;
        DiskFormat diskFormatTwo = DiskFormat.RAW;
        Integer minDiskTwo = 2048;
        Float minRamTwo = (float) 1024.0;
        Integer sizeTwo = 256;
        String operatingSystemTwo = "Linux 5.2";
        List<String> virtualizatiTwonvironmentTwo = new ArrayList<String>();

        VnfSoftwareImageDescriptionDto softwareImageDescriptionTwo = new VnfSoftwareImageDescriptionDto(imgIDTwo,
                imgNameTwo, imgVersionTwo,
                checksumTwo,
                imageURITwo,
                containerFormatTwo, diskFormatTwo, minDiskTwo, minRamTwo, sizeTwo,
                operatingSystemTwo,
                virtualizatiTwonvironmentTwo);

        String providerTwo = "MyProviderTwo";
        String softwareVersionTwo = "1.0.1";
        String productInfoNameTwo = "NO INFO";

        VnfDescriptorsDto vnfTwo = new VnfDescriptorsDto(
                idTwo, providerTwo, version, softwareVersionTwo, productInfoNameTwo,
                productInfoDescription, securityGroupRule, softwareImageDescriptionTwo);

        List<PalantirDeploymentModel> deploymentModelsTwo = new ArrayList<PalantirDeploymentModel>();
        deploymentModelsTwo.add(PalantirDeploymentModel.CLOUD);

        List<String> detectionMethodsTwo = new ArrayList<String>();
        detectionMethodsTwo.add("netflow_monitoring");

        List<String> mitigationMethodsTwo = new ArrayList<String>();
        mitigationMethodsTwo.add("network_flow_filtering");

        List<String> controlDataTypesTwo = new ArrayList<String>();
        controlDataTypesTwo.add("netflow_configuration");

        List<String> monitorDataTypesTwo = new ArrayList<String>();
        monitorDataTypesTwo.add("pcap");

        List<String> threatProtectionsTwo = new ArrayList<String>();
        threatProtectionsTwo.add("mitm");

        SCSecurityDto scSecTwo = new SCSecurityDto(
                deploymentModelsTwo,
                detectionMethodsTwo,
                mitigationMethodsTwo,
                controlDataTypesTwo, monitorDataTypesTwo, threatProtectionsTwo);

        List<BillingModelType> billingModelTwo = new ArrayList<BillingModelType>();
        billingModelTwo.add(BillingModelType.HOURLY);
        billingModelTwo.add(BillingModelType.INSTANCE);
        billingModelTwo.add(BillingModelType.SUBSCRIPTION);

        SCBillingSLADto scBillSLATwo = new SCBillingSLADto(billingModelTwo, subscriptionBilling,
                instanceBilling,
                hourlyBilling, slaDowntime, slaViolationFee);

        String scHashTwo = "string";
        SCIntegrityDto scIntTwo = new SCIntegrityDto(scHashTwo);

        Boolean sharesDataTwo = true;
        Boolean storesDataTwo = true;
        Boolean processesDataTwo = true;
        SCPrivacyDto scPrivTwo = new SCPrivacyDto(sharesDataTwo, storesDataTwo, processesDataTwo);

        this.scTwo = new SecurityCapabilityDetailsDto(
                idTwo, vnfTwo, scSecTwo,
                scBillSLATwo, scIntTwo, scPrivTwo);
    }

    public SecurityCapabilityDetailsDto getSample(int number) {
        if (number == 1) {
            return this.scOne;
        } else if (number == 2) {
            return this.scTwo;
        }
        return this.defaultSC;
    }

    public List<SecurityCapabilityDetailsDto> getSamples(int number) {
        List<SecurityCapabilityDetailsDto> retList = new ArrayList<SecurityCapabilityDetailsDto>();

        if (number >= 1) {
            retList.add(this.scOne);
        }
        if (number >= 2) {
            retList.add(this.scTwo);
        }
        if (number >= 3) {
            retList.add(this.defaultSC);
        }

        return retList;
    }

}
