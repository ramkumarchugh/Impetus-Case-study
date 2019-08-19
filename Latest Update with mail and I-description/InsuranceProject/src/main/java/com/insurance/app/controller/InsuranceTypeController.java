package com.insurance.app.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.app.model.BasePlan;
import com.insurance.app.model.InsuranceCategory;
import com.insurance.app.model.Premium;
import com.insurance.app.service.BasePlanService;
import com.insurance.app.service.InsuranceCategoryService;
import com.insurance.app.service.PremiumService;

/**
 * The Class InsuranceTypeController.
 */
@RestController
@RequestMapping(value = "insurance")
// @CrossOrigin(origins="http://172.29.57.66:8080")
@CrossOrigin(origins = "http://localhost:4200")

public class InsuranceTypeController {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(InsuranceTypeController.class);

    // For getting the category of the Insurance

    /** The service. */
    @Autowired
    InsuranceCategoryService service;

    /**
     * Gets the insurance category.
     *
     * @return the insurance category
     */
    @GetMapping
    public List<InsuranceCategory> getInsuranceCategory() {
        LOGGER.info(this.getClass().getSimpleName() + " - Get all insurance service is invoked.");
        return service.getInsuranceCategory();
    }

    /**
     * Gets the insurance category by id.
     *
     * @param insuranceId the insurance id
     * @return the insurance category by id
     * @throws Exception the exception
     */
    @GetMapping(value = "/{insuranceId}")
    public InsuranceCategory getInsuranceCategoryById(@PathVariable int insuranceId) throws Exception {
        LOGGER.info(this.getClass().getSimpleName() + " - Get insurance details by id is invoked.");

        Optional<InsuranceCategory> insurance = service.getInsuranceCategoryById(insuranceId);
        if (!insurance.isPresent())
            throw new Exception("Could not find insurance with id- " + insuranceId);

        return insurance.get();
    }

    /**
     * Update insurance.
     *
     * @param updateinsurance the update insurance
     * @param insuranceId the insurance id
     * @return the insurance category
     * @throws Exception the exception
     */
    @RequestMapping(value = "/{insuranceId}", method = RequestMethod.PUT)
    public InsuranceCategory updateInsurance(@RequestBody InsuranceCategory updateinsurance, @PathVariable int insuranceId) throws Exception {
        LOGGER.info(this.getClass().getSimpleName() + " - Update user details by id is invoked.");

        updateinsurance.setinsuranceId(insuranceId);
        return service.updateInsurance(updateinsurance);
    }

    // For getting the Base plan of the Insurance

    /** The ser. */
    @Autowired
    BasePlanService ser;

    /**
     * Gets the base plans.
     *
     * @return the base plans
     */
    @GetMapping(value = "/baseplan")
    public List<BasePlan> getBasePlans() {
        LOGGER.info(this.getClass().getSimpleName() + " - Get all baseplan service is invoked.");
        return ser.getBasePlans();
    }

    /**
     * Gets the base plan by id.
     *
     * @param baseplanId the base plan id
     * @return the base plan by id
     * @throws Exception the exception
     */
    @GetMapping(value = "/baseplan/{baseplanId}")
    public BasePlan getBasePlanById(@PathVariable int baseplanId) throws Exception {
        LOGGER.info(this.getClass().getSimpleName() + " - Get baseplan details by id is invoked.");

        Optional<BasePlan> plan = ser.getBasePlanById(baseplanId);
        if (!plan.isPresent())
            throw new Exception("Could not find insurance with id- " + baseplanId);

        return plan.get();
    }

    // Get the premium of the policy

    /** The premium. */
    @Autowired
    PremiumService premium;

    /**
     * Creates the premium.
     *
     * @param addpremium the add premium
     * @return the integer
     */
    @PostMapping(value = "/calculate_premium")
    public int createPremium(@RequestBody Premium addpremium) {
        LOGGER.info(this.getClass().getSimpleName() + " - Calculate premium new  method is invoked.");

        return premium.calculatePremium(addpremium);
    }

}