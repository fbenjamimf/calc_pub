Instruções para configuração do runner auto-hospedado (fora do YAML):

Na máquina local ou na nuvem, instalar e rodar o GitHub Actions Runner (seguir documentação oficial).

Durante a configuração, registrar o runner no repositório DevCalc.

Verificar se o runner aparece em “Settings → Actions → Runners”.

Este workflow utilizará aquele runner sempre que runs-on: self-hosted.

Variáveis e Secrets 
Antes de executar, deve-se criar em Settings → Actions → Variables:

APP_MODE com valor, por ex. development

SUPPORT_EMAIL com valor, por ex. suporte@devcalc.com

E em Settings → Actions → Secrets:

PROD_TOKEN com algum valor simulando token de produção.

 Workflow de Deploy em Dev 
 Configuração do environment dev no GitHub UI:

Vá em Settings → Environments no repositório e crie dev.

Não marque nenhuma proteção ou requisito de aprovação; liberação automática.

Pode definir variáveis específicas de ambiente para dev (opcional).

Workflow de Deploy em Prod

Configuração do environment prod no GitHub UI:

Em Settings → Environments, crie prod.

Adicione qualquer secreto específico (ex: PROD_DEPLOY_KEY) em Environment Secrets.

Em “Protection rules”, habilite “Required reviewers” e adicione ao menos um membro da equipe para aprovação manual.
