package com.mealmate.backend.service.impl;

import com.mealmate.backend.dto.UserPreferenceRequestDTO;
import com.mealmate.backend.dto.UserPreferenceResponseDTO;
import com.mealmate.backend.entity.User;
import com.mealmate.backend.entity.UserPreference;
import com.mealmate.backend.exception.ResourceNotFoundException;
import com.mealmate.backend.repository.UserPreferenceRepository;
import com.mealmate.backend.repository.UserRepository;
import com.mealmate.backend.service.UserPreferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPreferenceServiceImpl implements UserPreferenceService {

    private final UserPreferenceRepository userPreferenceRepository;
    private final UserRepository userRepository;

    @Override
    public UserPreferenceResponseDTO savePreference(UserPreferenceRequestDTO requestDTO) {

        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        UserPreference preference = new UserPreference();

        preference.setUser(user);
        preference.setDietType(requestDTO.getDietType());
        preference.setGoal(requestDTO.getGoal());
        preference.setBudget(requestDTO.getBudget());
        preference.setRegion(requestDTO.getRegion());
        preference.setAllergies(requestDTO.getAllergies());
        preference.setDislikedFoods(requestDTO.getDislikedFoods());
        preference.setMealsPerDay(requestDTO.getMealsPerDay());
        preference.setSpicyFood(requestDTO.getSpicyFood());
        preference.setSeasonalFood(requestDTO.getSeasonalFood());
        preference.setAiAutoUpdate(requestDTO.getAiAutoUpdate());

        UserPreference savedPreference = userPreferenceRepository.save(preference);

        return mapToResponse(savedPreference);
    }

    @Override
    public UserPreferenceResponseDTO getPreferenceByUserId(Long userId) {

        UserPreference preference = userPreferenceRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Preference not found"));

        return mapToResponse(preference);
    }

    @Override
    public UserPreferenceResponseDTO updatePreference(Long userId,
                                                      UserPreferenceRequestDTO requestDTO) {

        UserPreference preference = userPreferenceRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Preference not found"));

        preference.setDietType(requestDTO.getDietType());
        preference.setGoal(requestDTO.getGoal());
        preference.setBudget(requestDTO.getBudget());
        preference.setRegion(requestDTO.getRegion());
        preference.setAllergies(requestDTO.getAllergies());
        preference.setDislikedFoods(requestDTO.getDislikedFoods());
        preference.setMealsPerDay(requestDTO.getMealsPerDay());
        preference.setSpicyFood(requestDTO.getSpicyFood());
        preference.setSeasonalFood(requestDTO.getSeasonalFood());
        preference.setAiAutoUpdate(requestDTO.getAiAutoUpdate());

        UserPreference updatedPreference = userPreferenceRepository.save(preference);

        return mapToResponse(updatedPreference);
    }

    @Override
    public void deletePreference(Long userId) {

        UserPreference preference = userPreferenceRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Preference not found"));

        userPreferenceRepository.delete(preference);
    }

    private UserPreferenceResponseDTO mapToResponse(UserPreference preference) {

        UserPreferenceResponseDTO response = new UserPreferenceResponseDTO();

        response.setId(preference.getId());
        response.setUserName(preference.getUser().getFullName());
        response.setDietType(preference.getDietType());
        response.setGoal(preference.getGoal());
        response.setBudget(preference.getBudget());
        response.setRegion(preference.getRegion());
        response.setAllergies(preference.getAllergies());
        response.setDislikedFoods(preference.getDislikedFoods());
        response.setMealsPerDay(preference.getMealsPerDay());
        response.setSpicyFood(preference.getSpicyFood());
        response.setSeasonalFood(preference.getSeasonalFood());
        response.setAiAutoUpdate(preference.getAiAutoUpdate());

        return response;
    }
}