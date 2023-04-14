CREATE TABLE IF NOT EXISTS public.servicos
(
    codigo_servico serial8,
    descricao character varying(255),
    valor_claro double precision,
    valor_tecnico double precision,
    CONSTRAINT servicos_pkey PRIMARY KEY (codigo_servico)
    );

CREATE TABLE IF NOT EXISTS public.tecnico
(
    codigo_tecnico serial8,
    nome character varying(255),
    cpf character varying(255),
    data_admissao timestamp without time zone,
    CONSTRAINT tecnico_pkey PRIMARY KEY (codigo_tecnico)
    );

CREATE TABLE IF NOT EXISTS public.servicos_executados
(
    contrato integer,
    data_execucao timestamp without time zone,
    servicos bigint,
    tecnico bigint,
    CONSTRAINT servicos_executados_pkey PRIMARY KEY (contrato),
    CONSTRAINT servicos_executados_servicos_fkey FOREIGN KEY (servicos)
    REFERENCES public.servicos (codigo_servico) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT servicos_executados_tecnico_fkey FOREIGN KEY (tecnico)
    REFERENCES public.tecnico (codigo_tecnico) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    );