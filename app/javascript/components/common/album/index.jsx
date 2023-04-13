import React from 'react'
import styled from 'styled-components'
import { Image, Heading } from 'react-bulma-components'
import { Link } from 'react-router-dom'

const DivVSpaced = styled.div`
  margin-top: 10px;
`

export default function Album(props) {
  return (
    <Link to={`/album/${props.id}`}>
      <Image src={props.cover_url} />
      <DivVSpaced>
        <Heading size={6} className='has-text-white'>{props.title}</Heading>
        <Heading size={6} className='has-text-white' subtitle>{props.artist_name}</Heading>
      </DivVSpaced>
    </Link>
  )
}