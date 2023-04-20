import React from "react"
import HomeScreen from "./screens/home"
import DiscoveryScreen from "./screens/discovery"
import SearchScreen from "./screens/search"
import AlbumScreen from "./screens/album"
import FavoritesScreen from "./screens/favorites"
import { Routes as Switch, Route } from "react-router-dom"

export default function Routes() {
  return (
    <Switch>
      <Route exact path="/" element={HomeScreen()} />
      <Route exact path="/discovery" element={DiscoveryScreen()} />
      <Route exact path="/search" element={SearchScreen()} />
      <Route exact path="/album/:id" element={AlbumScreen()} />
      <Route exact path="/favorites" element={FavoritesScreen()} />
    </Switch>
  )
}