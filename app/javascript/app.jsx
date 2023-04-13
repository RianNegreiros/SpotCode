import React from 'react'
import 'react-bulma-components/dist/react-bulma-components.min.css'
import 'app.scss'
import { BrowserRouter } from 'react-router-dom'
import Routes from './routes'
import Menu from './components/commom/menu'

export default function App() {
  return (
    <>
      <BrowserRouter>
        <Menu />
        <Routes />
      </BrowserRouter>
    </>
  )
}