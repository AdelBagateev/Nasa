//
//  ddd.swift
//  iosApp
//
//  Created by Elina Abdrakhmanova on 03.06.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Combine
import Shared

class PhotoByCoordinatesViewModelWrapper: ObservableObject {
    @Published var satellitePhotoUrl: URL?

    private let viewModel = PhotoByCoordinatesViewModel()

    init() {
        viewModel.addObserver { [weak self] state in
            if let photo = state.satellitePhoto {
                self?.satellitePhotoUrl = URL(string: photo.url)
            }
        }
    }

    func getPhotoByCoordinates(lat: Int, lon: Int) {
        viewModel.obtainEvent(event: PhotoByCoordinatesEvent.GetPhoto(lat: Int32(lat), lon: Int32(lon)))
    }
}
