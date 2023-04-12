json.title
josn.cover_url

json.songs @songs.each do |song|
  json.id song.id
  json.title song.title
  json.file_url url_for(song.file)
end