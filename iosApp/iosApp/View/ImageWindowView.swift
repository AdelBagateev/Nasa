//
//  ImageWindowView.swift
//  iosApp
//
//  Created by Elina Abdrakhmanova on 03.06.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ImageWindowView: View {
    let imageUrl: URL?

    var body: some View {
        if let imageUrl = imageUrl {
            AsyncImage(url: imageUrl) { image in
                image.resizable()
                     .scaledToFit()
            } placeholder: {
                ProgressView()
            }
        } else {
            Text("No Image Available")
        }
    }
}

