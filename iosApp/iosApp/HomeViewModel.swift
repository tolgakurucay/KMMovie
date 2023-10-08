//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Tolga Kurucay on 8.10.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

@MainActor
class HomeViewModel: ObservableObject{
    
    private let getMoviesUseCase = GetMoviesUseCase.init()
    
    @Published private(set) var tolgasMovies : [Movie] = []
    @Published private(set) var isLoading: Bool = false
    private(set) var loadFinished: Bool = false
    private var currentPage = 1
    
    func loadMovies() async {
        
        if isLoading{
            return
        }
        do{
            let movies = try await getMoviesUseCase.invoke(page: Int32(currentPage))
            isLoading = false
            loadFinished = movies.isEmpty
            
            //pagination
            currentPage+=1
            self.tolgasMovies += movies
        }
        catch{
            isLoading = false
            loadFinished = true
        }
        
    }
    
}
