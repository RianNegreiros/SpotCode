import React from 'react'
import 'react-bulma-components/dist/react-bulma-components.min.css'
import 'app.scss'
import Router from './routes'
import { BrowserRouter } from 'react-router-dom'
import Menu from './components/common/menu'

export default function App() {
  return (
    <>
      <BrowserRouter>
        <Menu />
        <Router />
      </BrowserRouter>
    </>
  )
}