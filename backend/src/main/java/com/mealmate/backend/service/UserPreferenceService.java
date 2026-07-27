package com.mealmate.backend.service;

import com.mealmate.backend.dto.UserPreferenceRequestDTO;
import com.mealmate.backend.dto.UserPreferenceResponseDTO;

public interface UserPreferenceService {

    UserPreferenceResponseDTO savePreference(UserPreferenceRequestDTO requestDTO);

    UserPreferenceResponseDTO getPreferenceByUserId(Long userId);

    UserPreferenceResponseDTO updatePreference(Long userId, UserPreferenceRequestDTO requestDTO);

    void deletePreference(Long userId);
}