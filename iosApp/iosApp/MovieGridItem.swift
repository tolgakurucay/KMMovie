//
//  MovieGridItem.swift
//  iosApp
//
//  Created by Tolga Kurucay on 8.10.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MovieGridItem: View {
    
    let movie: Movie
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8){
            ZStack(){
                AsyncImage(url: URL(string: movie.imageUrl)){
                    image in
                    image.resizable()
                    
                } placeholder: {
                    Color.gray
                }
                
                Circle().frame(width: 50,height: 50)
                    .foregroundColor(.black.opacity(0.7))
                
                Image(systemName: "play.fill")
                    .foregroundColor(Color.white)
            }.frame(maxWidth: .infinity,idealHeight:.infinity)
                .clipShape(RoundedRectangle(cornerRadius: 16))
            
            Text(movie.title)
                .font(.title3)
                .fontWeight(.bold)
                .lineLimit(1)
            
            Text(movie.releaseDate)
                .font(.caption)
            
            
            
            
        }.frame(maxWidth: .infinity,maxHeight: 260)
    }
}

struct MovieGridItem_Previews: PreviewProvider {
    static var previews: some View {
        MovieGridItem(movie:
                        Movie(id: 12312, title: "Göknurun Günlükleri", description: "Arzunun Günlükleri Açıklama Kısmı", imageUrl: "https://inhousestaffing.com/wp-content/uploads/2017/07/housekeepers-san-francisco-bay-area-1.jpg", releaseDate: "03.03.1978"))
    }
}
