import React from 'react'
import 'react-bulma-components/dist/react-bulma-components.min.css'
import 'app.scss'
import { BrowserRouter } from 'react-router-dom'
import Routes from './routes'

export default function App() {
  return (
    <>
      <BrowserRouter>
        <Routes />
      </BrowserRouter>
    </>
  )
}