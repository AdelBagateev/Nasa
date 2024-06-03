//
//  AboutSpaceViewModelWrapper.swift
//  iosApp
//
//  Created by Elina Abdrakhmanova on 03.06.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Combine
import Shared

class AboutSpaceViewModelWrapper: ObservableObject {
    @Published var cosmicBodies: [CosmicBody] = []

    private let viewModel = AboutSpaceViewModel()
    private var cancellables = Set<AnyCancellable>()

    init() {
        viewModel.viewState
            .collect { state in
                DispatchQueue.main.async {
                    self.cosmicBodies = state.cosmicBodies
                }
            }
            .store(in: &cancellables)
    }

    func onSeeAllCosmicBodyClick() {
        viewModel.obtainEvent(event: AboutSpaceEvent.OnSeeAllCosmicBodyClick())
    }
}

